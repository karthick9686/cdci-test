package com.adv.amfi.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adv.amfi.model.SchemeMapping;
import com.adv.amfi.model.SchemeRollingReturns;
import com.adv.amfi.repository.SchemeMappingRepository;
import com.adv.amfi.repository.SchemeRollingReturnsRepository;
import com.adv.utils.AmfiCronGeneralFunctions;
import com.adv.utils.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RollingReturnsDAO {

	List<SchemeMapping> schemeMappingList;
	
	@Autowired
	private SchemeMappingRepository schemeMappingRepository;
	
	@Autowired
	private SchemeRollingReturnsRepository schemeRollingReturnsRepository;
	
	@Autowired
	@Qualifier("amfiEntityManagerFactory")
	private EntityManager amfiSession;
	
	
	
	@SuppressWarnings("unchecked")
	public void getSchemeMapping() {
		
		Query query;
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		
		//schemeMappingList = schemeMappingRepository.findAll();
		
		//System.out.println(schemeMappingList.size());
		
		query = amfiSession.createQuery("from SchemeMapping");
		System.out.println("Starting " + fmt.format(new Date()));
		schemeMappingList = query.getResultList();
		
		for (SchemeMapping schemeMapping : schemeMappingList) {
			//System.out.println(schemeMapping.getScheme_amfi());
		}
		
		System.out.println(schemeMappingList.size());
		System.out.println("Ending " + fmt.format(new Date()));
	}
	
	/*@Transactional
	public void saveAllSchemeRolling(List<SchemeRollingReturns> productData){
        System.out.println("insert using saveAll");
        schemeRollingReturnsRepository.saveAllAndFlush(productData);
    }*/
	
	@SuppressWarnings("unchecked")
	public void updateSchemeRollingReturns(int rowNo)
	{
        
        List<SchemeRollingReturns> schemeRollingReturnsList = null;
        SchemeRollingReturns schemeRollingReturns = null;
        
        //int sessionFlushCount = 0;
        Query query = null;
        Date today = null;
        List<Object> schemeMappingList = null;
        List<Object> scheme_nav_list = null;
        List<String> periodList = null;
        List<Object> dv_list = null;
        List<Date> datesList = null;
        List<SchemeRollingReturns> schemeRollingReturnsList1 = null;
        
		try
		{
			
			
			//session = AmfiCronSessionFactory.getSessionFactorySession();
			//session.getTransaction().begin();
			
			String sql = "select scheme_company,scheme_advisorkhoj_category,scheme_amfi,"
					+ "scheme_amfi_code,url,scheme_amfi_common,scheme_amfi_short_name,scheme_plan_type from scheme_mapping "
					+ "where active = 1 and scheme_amfi_code != '' and scheme_amfi_code is not null "
					+ "and scheme_amfi not like '%Institutiona%' and scheme_amfi not like '%bonus%' "
					+ "order by scheme_advisorkhoj_category asc limit " + rowNo + ",1";
			//System.out.println(sql);
			query = amfiSession.createNativeQuery(sql);
			schemeMappingList = query.getResultList();

			//System.out.println("schemeMappingList.size() = "+schemeMappingList.size());
			
			today = new Date();
     		for (Object schemeMap : schemeMappingList) 
     		{
     			Object[] schemeMapRow = (Object[]) schemeMap;
     			String scheme_company = String.valueOf(schemeMapRow[0]);
     			String scheme_category = String.valueOf(schemeMapRow[1]);
     			String scheme_amfi = String.valueOf(schemeMapRow[2]);
     			String scheme_amfi_code = String.valueOf(schemeMapRow[3]);
     			String scheme_url = String.valueOf(schemeMapRow[4]);
     			String scheme_amfi_common = String.valueOf(schemeMapRow[5]);
     			String scheme_amfi_short_name =  String.valueOf(schemeMapRow[6]);
     			String scheme_plan_type =  String.valueOf(schemeMapRow[7]);
     			
     			Date navStartDate = null;
     			Double yearDiff = 0.0;
				List<Date> dateMap = getSchemeStartAndEndDate(scheme_amfi_code, amfiSession);
				if(dateMap != null && dateMap.size() > 0) 
				{
					navStartDate = dateMap.get(0);
					yearDiff = AmfiCronGeneralFunctions.getDiffYears(navStartDate, today);
				}
				if(yearDiff < 1)
				{
					continue;
				}
				
				//count++;
				System.out.println((rowNo+1) + " - " + scheme_amfi + " at " + new Date());
				//System.out.println(schemeMapping.getScheme_advisorkhoj_category() + " -> " +  schemeMapping.getScheme_amfi() + " - inception - " + schemeMapping.getScheme_inception_date() + " diff is " + yearDiff);
				
				query = amfiSession.createNativeQuery("select nav_date, net_asset_value from amfi_mf_nav where scheme_code = '" + scheme_amfi_code + "' and net_asset_value != 0 order by nav_date asc");
				scheme_nav_list = query.getResultList();
				//System.out.println("scheme_nav_list size --->"+scheme_nav_list.size());

				periodList = new ArrayList<String>();
				//periodList.add("15 Days");
				periodList.add("1 Month");
				//periodList.add("3 Month");
				//periodList.add("6 Month");
				
				periodList.add("1 Year");
				periodList.add("2 Year");
				periodList.add("3 Year");
				periodList.add("5 Year");
				periodList.add("7 Year");
				periodList.add("10 Year");
				periodList.add("15 Year");
				periodList.add("20 Year");
				periodList.add("25 Year");
				
				for (String period : periodList) 
				{
		     		//System.out.println("period--------->"+period);
					
					Calendar cal = null;
					Date list1_end_date = null;
					Date list2_start_date = null;	
					if(period.equalsIgnoreCase("15 Days"))
					{
						cal = Calendar.getInstance();
			     		cal.add(Calendar.DATE, -16);
						list1_end_date = cal.getTime();
			     		
			     		cal = Calendar.getInstance();
			     		cal.setTime(navStartDate);
			     		cal.add(Calendar.DATE, 16);
						list2_start_date = cal.getTime();	
					}else if(period.equalsIgnoreCase("1 Month") || period.equalsIgnoreCase("3 Month") || period.equalsIgnoreCase("6 Month"))
					{
						int period_int = 1;
						if(period.equalsIgnoreCase("1 Month"))
						{
							period_int = 1;
						}else if(period.equalsIgnoreCase("3 Month"))
						{
							period_int = 3;
						}else
						{
							period_int = 6;
						}
						cal = Calendar.getInstance();
			     		cal.add(Calendar.DATE, -1);
			     		cal.add(Calendar.MONTH, -period_int);
						list1_end_date = cal.getTime();
			     		
			     		cal = Calendar.getInstance();
			     		cal.setTime(navStartDate);
			     		cal.add(Calendar.MONTH, period_int);
						list2_start_date = cal.getTime();	
					}else
					{
						int period_int = 1;
						if(period.equalsIgnoreCase("1 Year"))
						{
							period_int = 1;
						}else if(period.equalsIgnoreCase("3 Year"))
						{
							period_int = 3;
						}else if(period.equalsIgnoreCase("5 Year"))
						{
							period_int = 5;
						}else if(period.equalsIgnoreCase("10 Year"))
						{
							period_int = 10;
						}else if(period.equalsIgnoreCase("2 Year"))
						{
							period_int = 2;
						}else if(period.equalsIgnoreCase("7 Year"))
						{
							period_int = 7;
						}else if(period.equalsIgnoreCase("20 Year"))
						{
							period_int = 20;
						}else if(period.equalsIgnoreCase("25 Year"))
						{
							period_int = 25;
						}else
						{
							period_int = 15;
						}
						cal = Calendar.getInstance();
			     		cal.add(Calendar.DATE, -1);
			     		cal.add(Calendar.YEAR, -period_int);
						list1_end_date = cal.getTime();
			     		
			     		cal = Calendar.getInstance();
			     		cal.setTime(navStartDate);
			     		cal.add(Calendar.YEAR, period_int);
						list2_start_date = cal.getTime();	
					}
					
					//System.out.println("navStartDate = "+navStartDate);
					//System.out.println("list1_end_date = "+list1_end_date);
					//System.out.println("list2_start_date = "+list2_start_date);
					
					query = amfiSession.createNativeQuery("select scheme_date,hdfc_date from scheme_nav_dates where scheme_amfi_code = '"+scheme_amfi_code+"'");
					dv_list = query.getResultList();
					
					datesList = new ArrayList<Date>();
					
					if(dv_list != null && dv_list.size() > 0)
					{
						for (Object object : dv_list) 
			     		{		     			
			     			Object[] row = (Object[]) object;						
							datesList.add((Date)row[0]);
			     		}
					}					
					
		     		schemeRollingReturnsList = new ArrayList<SchemeRollingReturns>();
		     		

		     		for (Object object : scheme_nav_list) 
		     		{
		     			String category_short_name = Utils.getCategoryNameShort(scheme_category);
		     			Object[] row = (Object[]) object;
		     			
		     			
		     			if(datesList != null && datesList.size() > 0)
						{
		     				if(datesList.contains((Date)row[0]))
			     			{
								schemeRollingReturns = new SchemeRollingReturns();
								schemeRollingReturns.setNav_date((Date)row[0]);
								schemeRollingReturns.setScheme_nav((Double)row[1]);
								schemeRollingReturns.setScheme_company(scheme_company);
								schemeRollingReturns.setScheme_name(scheme_amfi);
								schemeRollingReturns.setScheme_amfi_code(scheme_amfi_code);
								schemeRollingReturns.setPeriod(period);
								schemeRollingReturns.setScheme_category(scheme_category);
								schemeRollingReturns.setCategory_short_name(category_short_name);
								schemeRollingReturns.setUrl(scheme_url);
								schemeRollingReturns.setScheme_amfi_common(scheme_amfi_common);
								schemeRollingReturns.setScheme_amfi_short_name(scheme_amfi_short_name);
								schemeRollingReturns.setScheme_plan_type(scheme_plan_type);
								schemeRollingReturnsList.add(schemeRollingReturns);
			     			}
		     				else
		     				{
		     					
		     				}
						}
		     			else
		     			{
		     				schemeRollingReturns = new SchemeRollingReturns();
							schemeRollingReturns.setNav_date((Date)row[0]);
							schemeRollingReturns.setScheme_nav((Double)row[1]);
							schemeRollingReturns.setScheme_company(scheme_company);
							schemeRollingReturns.setScheme_name(scheme_amfi);
							schemeRollingReturns.setScheme_amfi_code(scheme_amfi_code);
							schemeRollingReturns.setPeriod(period);
							schemeRollingReturns.setScheme_category(scheme_category);
							schemeRollingReturns.setCategory_short_name(category_short_name);
							schemeRollingReturns.setUrl(scheme_url);
							schemeRollingReturns.setScheme_amfi_common(scheme_amfi_common);
							schemeRollingReturns.setScheme_amfi_short_name(scheme_amfi_short_name);
							schemeRollingReturns.setScheme_plan_type(scheme_plan_type);
							schemeRollingReturnsList.add(schemeRollingReturns);
		     			}
		     		}
		     		//System.out.println("list size = "+schemeRollingReturnsList.size());
		     		
		     		List<SchemeRollingReturns> list1 = new ArrayList<SchemeRollingReturns>();
	                TreeMap<Date, Double> list2_map = new TreeMap<Date, Double>();
		     		
		     		for (SchemeRollingReturns obj : schemeRollingReturnsList)
	                {
	                    Date scheme_nav_date = obj.getNav_date();
	                    if(scheme_nav_date.compareTo(list1_end_date) > 0)
	                    {
	                        //System.out.println("list1 breaking date --------->"+scheme_nav_date);
	                        break;
	                    }else{
	                    	list1.add(obj);
	                    }
	                }
		     		
		     		if(list1.size() == 0)
		     		{
		     			continue;
		     		}
	                
	                for (SchemeRollingReturns obj : schemeRollingReturnsList)
	                {
	                	Date scheme_nav_date = obj.getNav_date();
	                    Double scheme_nav = obj.getScheme_nav();
	                    
	                    if(scheme_nav_date.compareTo(list2_start_date) < 0)
	                    {
	                        continue;
	                    }else{
		                	list2_map.put(scheme_nav_date, scheme_nav);
	                    }
	                }
	                
	                if(list2_map.size() == 0)
		     		{
		     			continue;
		     		}
	                
	                //System.out.println("list1 start size = "+list1.size());
	                //System.out.println("list2_map size = "+list2_map.size());
	                int pos = 0;
	                
	                schemeRollingReturnsList1 = new ArrayList<SchemeRollingReturns>();;
	                
	                for (SchemeRollingReturns obj : list1)
	                {
	                	//obj.setId(id);
	                	//id++;
	                	
	                	
	                	Date scheme_nav_date = obj.getNav_date();
	                    Double scheme_nav = obj.getScheme_nav();
	                    
	                    cal = Calendar.getInstance();
	    	            cal.setTime(scheme_nav_date);
	    	            if(period.equalsIgnoreCase("15 Days"))
						{
				     		cal.add(Calendar.DATE, 16);
							
						}else if(period.equalsIgnoreCase("1 Month") || period.equalsIgnoreCase("3 Month") || period.equalsIgnoreCase("6 Month"))
						{
							int period_int = 1;
							if(period.equalsIgnoreCase("1 Month"))
							{
								period_int = 1;
							}else if(period.equalsIgnoreCase("3 Month"))
							{
								period_int = 3;
							}else
							{
								period_int = 6;
							}
				     		cal.add(Calendar.MONTH, period_int);
						}else
						{
							int period_int = 1;
							if(period.equalsIgnoreCase("1 Year"))
							{
								period_int = 1;
							}else if(period.equalsIgnoreCase("3 Year"))
							{
								period_int = 3;
							}else if(period.equalsIgnoreCase("5 Year"))
							{
								period_int = 5;
							}else if(period.equalsIgnoreCase("10 Year"))
							{
								period_int = 10;
							}else if(period.equalsIgnoreCase("2 Year"))
							{
								period_int = 2;
							}else if(period.equalsIgnoreCase("7 Year"))
							{
								period_int = 7;
							}else if(period.equalsIgnoreCase("20 Year"))
							{
								period_int = 20;
							}else if(period.equalsIgnoreCase("25 Year"))
							{
								period_int = 25;
							}else
							{
								period_int = 15;
							}
				     		cal.add(Calendar.YEAR, period_int);
						}
			            Date scheme_forward_nav_date = cal.getTime();
			            
			            if(list2_map.containsKey(scheme_forward_nav_date))
			            {
			            	//System.out.println("if.....>"+scheme_forward_nav_date);
			            	pos = list2_map.headMap(scheme_forward_nav_date).size();
		                    Double scheme_forward_nav = list2_map.get(scheme_forward_nav_date);
		                    
		                    Double scheme_rolling_returns = 0.0;
		                    double scheme_roundOff = 0;
		                    if(period.equalsIgnoreCase("15 Days") || period.equalsIgnoreCase("1 Month") || period.equalsIgnoreCase("3 Month") || period.equalsIgnoreCase("6 Month") || period.equalsIgnoreCase("1 Year"))
		                    {
		                    	scheme_rolling_returns = ((scheme_forward_nav / scheme_nav) - 1) * 100;
		                        scheme_roundOff = (double) Math.round(scheme_rolling_returns * 100) / 100;
		                    }else
		                    {
		                    	double forward_year_double = 1.0;
								if(period.equalsIgnoreCase("1 Year"))
								{
									forward_year_double = 1.0;
								}else if(period.equalsIgnoreCase("3 Year"))
								{
									forward_year_double = 3.0;
								}else if(period.equalsIgnoreCase("5 Year"))
								{
									forward_year_double = 5.0;
								}else if(period.equalsIgnoreCase("10 Year"))
								{
									forward_year_double = 10.0;
								}else if(period.equalsIgnoreCase("2 Year"))
								{
									forward_year_double = 2.0;
								}else if(period.equalsIgnoreCase("7 Year"))
								{
									forward_year_double = 7.0;
								}else if(period.equalsIgnoreCase("20 Year"))
								{
									forward_year_double = 20.0;
								}else if(period.equalsIgnoreCase("25 Year"))
								{
									forward_year_double = 25.0;
								}else
								{
									forward_year_double = 15.0;
								}
		                    	scheme_rolling_returns = (Math.pow((scheme_forward_nav / scheme_nav),(1/forward_year_double)) - 1) * 100;
		                        scheme_roundOff = (double) Math.round(scheme_rolling_returns * 100) / 100;
		                    }
		                    
		                    obj.setScheme_forward_date(scheme_forward_nav_date);
		                    obj.setScheme_forward_nav(scheme_forward_nav);
		                    obj.setScheme_rolling_returns(scheme_roundOff);
		                    
		                    //sessionFlushCount++;
		                    
		                    //amfiSession.persist(obj);
		                    
		                    schemeRollingReturnsList1.add(obj);
		                    
		                    /*if( sessionFlushCount % 100 == 0 ) {
		                    	   amfiSession.flush();
		                    	   amfiSession.clear();
					               sessionFlushCount = 0;
					        }*/
			            }
			            else
			            {
			            	Set<Map.Entry<Date, Double>> entries = list2_map.entrySet();
			            	//System.out.println("else.....>"+scheme_forward_nav_date);
			            	if(pos > 0)
			            	{
			            		Map.Entry<Date, Double>[] entryArray = entries.toArray( new Map.Entry[entries.size()] );		                    
			                    
			            		//get key at index 2
			                    //System.out.println( "Key at index 2: " + entryArray[pos-1].getKey() );
			                    scheme_forward_nav_date = entryArray[pos-1].getKey();
			                    //get value at index 2
			                    Double scheme_forward_nav = entryArray[pos-1].getValue(); 		                    
			                    //System.out.println( "Value at index 2: " +entryArray[pos-1].getValue() );
			                    //System.out.println( "Value at index 2: " +scheme_forward_nav);
			            		//Double scheme_forward_nav = 0.0;		            		
			            					            			                    
			                   	                    
			                    Double scheme_rolling_returns = 0.0;
			                    double scheme_roundOff = 0;
			                    if(period.equalsIgnoreCase("15 Days") || period.equalsIgnoreCase("1 Month") || period.equalsIgnoreCase("3 Month") || period.equalsIgnoreCase("6 Month") || period.equalsIgnoreCase("1 Year"))
			                    {
			                    	scheme_rolling_returns = ((scheme_forward_nav / scheme_nav) - 1) * 100;
			                        scheme_roundOff = (double) Math.round(scheme_rolling_returns * 100) / 100;
			                    }else
			                    {
			                    	double forward_year_double = 1.0;
									if(period.equalsIgnoreCase("1 Year"))
									{
										forward_year_double = 1.0;
									}else if(period.equalsIgnoreCase("3 Year"))
									{
										forward_year_double = 3.0;
									}else if(period.equalsIgnoreCase("5 Year"))
									{
										forward_year_double = 5.0;
									}else if(period.equalsIgnoreCase("10 Year"))
									{
										forward_year_double = 10.0;
									}else if(period.equalsIgnoreCase("2 Year"))
									{
										forward_year_double = 2.0;
									}else if(period.equalsIgnoreCase("7 Year"))
									{
										forward_year_double = 7.0;
									}else if(period.equalsIgnoreCase("20 Year"))
									{
										forward_year_double = 20.0;
									}else if(period.equalsIgnoreCase("25 Year"))
									{
										forward_year_double = 25.0;
									}else
									{
										forward_year_double = 15.0;
									}
			                    	scheme_rolling_returns = (Math.pow((scheme_forward_nav / scheme_nav),(1/forward_year_double)) - 1) * 100;
			                        scheme_roundOff = (double) Math.round(scheme_rolling_returns * 100) / 100;
			                    }
			                    
			                    obj.setScheme_forward_date(scheme_forward_nav_date);
			                    obj.setScheme_forward_nav(scheme_forward_nav);
			                    obj.setScheme_rolling_returns(scheme_roundOff);
			                    
			                    //sessionFlushCount++;
			                    
			                    //amfiSession.persist(obj);
			                    schemeRollingReturnsList1.add(obj);
			                    
			                    /*if( sessionFlushCount % 100 == 0 ) {
			                    	   amfiSession.flush();
			                    	   amfiSession.clear();
						               sessionFlushCount = 0;
						        }*/
			            	}
			            }
	                }	
	                

	                //saveAllSchemeRolling(schemeRollingReturns);
	                schemeRollingReturnsRepository.saveAll(schemeRollingReturnsList1);
	                //schemeRollingReturnsRepository.flush();
	                //schemeRollingReturnsRepository.
	          
	                
	                //System.out.println("rolling returns completed for this period = > " +  period + " count " + schemeRollingReturns.size());
	                //schemeRollingReturns.clear();
	                
				}
			}
			
			/*session.getTransaction().commit();
			
			session = AmfiCronSessionFactory.getSessionFactorySession();
			session.getTransaction().begin();
			
			System.out.println("***** Rolling Returns Drop Table Started *****");
			query = session.createSQLQuery("DROP TABLE scheme_rolling_returns;");
			query.executeUpdate();	
			System.out.println("***** Rolling Returns Drop Table Ended *****");
			
			System.out.println("***** Rolling Returns ALTER Table Started *****");
			query = session.createSQLQuery("ALTER TABLE scheme_rolling_returns_temp RENAME TO scheme_rolling_returns;");
			query.executeUpdate();
			System.out.println("***** Rolling Returns ALTER Table Ended *****");
			
			System.out.println("***** Rolling Returns New Table Started *****");
			query = session.createSQLQuery("CREATE TABLE scheme_rolling_returns_temp LIKE scheme_rolling_returns;");
			query.executeUpdate();	
			System.out.println("***** Rolling Returns New Table Ended *****");
			
			session.getTransaction().commit();
			
			String result = HttpPost.sendGet("https://mfapi.advisorkhoj.com/clearCache");
     		System.out.println(result);*/

			
		}
		catch(Exception ex)
		{
			//session.getTransaction().rollback();
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Date> getSchemeStartAndEndDate(String scheme_amfi_code, EntityManager session) {
		
	    List<Date> dateMap = null;        
	    Query query = null;
	    
		try
		{
			dateMap = new ArrayList<Date>();
			
			query = session.createNativeQuery("select nav_date from amfi_mf_nav where scheme_code = '"+ scheme_amfi_code +"' order by nav_date asc limit 1");
			List<Date> date_list = query.getResultList();
			if(date_list !=null && date_list.size() > 0){
				dateMap.add(date_list.get(0));
			}
			
			query = session.createNativeQuery("SELECT nav_date FROM latest_nav where scheme_code = '" + scheme_amfi_code + "' order by nav_date desc limit 1");
			date_list = query.getResultList();
			if(date_list !=null && date_list.size() > 0)
			{
				dateMap.add(date_list.get(0));
			}else
			{
				query = session.createNativeQuery("select nav_date from amfi_mf_nav where scheme_code = '"+ scheme_amfi_code +"' order by nav_date desc limit 1");
				date_list = query.getResultList();
				if(date_list !=null && date_list.size() > 0){
					dateMap.add(date_list.get(0));
				}
			}			
		}
		catch(Exception ex)
		{
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return dateMap;
	}
	
}
