package com.adv.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.http.HttpServletRequest;


public class Utils {
	
	public static int investorTypeId = 1;
	public static int rmTypeId = 2;
	public static int fhTypeId = 3;
	public static int subTypeId = 4;
	public static int adminTypeId = 5;
	public static int backOfficeTypeId = 6;
	public static int branchTypeId = 7;
	public static String expection = "Expection";
	
	public static List<String> getClientList()
	{
		List<String> client_list = new ArrayList<String>();		
		client_list.add("sunshine");
		client_list.add("wealthygain");
		client_list.add("vbuildwealth");
		client_list.add("icisinvest");	
		client_list.add("skinvestments");
		client_list.add("wealthexpress");
		client_list.add("hmmercantile");
		client_list.add("bridge");
		client_list.add("mymfnow");
		client_list.add("tradejini");
		client_list.add("neowealth");	
		client_list.add("mfonline");
		client_list.add("fiducial");
		client_list.add("assetbaazar");		
		client_list.add("wealthscienceindia");
		client_list.add("reachyourgoals");
		client_list.add("ultimatewealth");
		client_list.add("wealthmaxindia");
		client_list.add("myefunds");				
		client_list.add("mutualfundskaro");
		client_list.add("inprism");
		client_list.add("dakshin");
		client_list.add("wealthmarga");
		client_list.add("fortunawealth");
		client_list.add("financialsolution");
		client_list.add("r2a");
		client_list.add("riqr");
		client_list.add("top3choice");
		client_list.add("moneymine");
		client_list.add("rsconsultants");
		client_list.add("entrust");
		client_list.add("wealthsecure");
		client_list.add("advisorkhoj");
		client_list.add("counton");
		client_list.add("eureka");
		client_list.add("orange");
		client_list.add("finatrium");
		client_list.add("maafinvest");
		client_list.add("moneyjournee");
		client_list.add("dnprasad");
		client_list.add("gmconsultancy");
		client_list.add("ncosecurities");
		client_list.add("starsip");
		client_list.add("wealthinsight");
		client_list.add("investpro");
		client_list.add("aniram");
		client_list.add("glosomelife");
		client_list.add("sjcapital");
		client_list.add("trianglewealth");
		client_list.add("shilpaassociates");
		client_list.add("ushaben");
		client_list.add("fliber");
		client_list.add("marinawealth");
		client_list.add("spfinancial");
		client_list.add("kubot");
		client_list.add("mcfinancial");
		client_list.add("skwealthcreation");
		client_list.add("fortuneinvestment");
		client_list.add("gallant");
		client_list.add("nereyeth");
		client_list.add("shriram");
		client_list.add("phipartners");
		client_list.add("investmentservices");
		client_list.add("fundsmantra");
		client_list.add("ayyavu");
		client_list.add("phoenix");
		client_list.add("rkgupta");
		client_list.add("waldalwealth");
		client_list.add("aalwarfinance");
		client_list.add("karthifinancial");
		client_list.add("ssvfinanciial");
		client_list.add("maruthi");
		client_list.add("moneyplus");
		client_list.add("primemoney");
		client_list.add("kailashfinancial");
		client_list.add("maxgrowwealth");
		client_list.add("khushiwealth");
		client_list.add("deepakochhar");
		client_list.add("allworth");
		client_list.add("kannan");
		client_list.add("mohandass");
		client_list.add("saiwealth");
		client_list.add("buildwealth");
		client_list.add("rajan");
		client_list.add("wecare");
		client_list.add("jindalnivesh");
		client_list.add("bhaaskinvestments");
		client_list.add("emryn");
		client_list.add("newhorizonwealth");
		client_list.add("yuvaraj");
		client_list.add("manikandan");
		client_list.add("krvaradarajan");
		client_list.add("ramu");
		client_list.add("betalpha");
		client_list.add("justinvest");
		client_list.add("nimesh");
		client_list.add("nfinvest");
		client_list.add("veerafinserve");
		client_list.add("dhanartha");
		client_list.add("shrimadhavrayinvestment");
		client_list.add("navjivan");
		client_list.add("alokkumar");
		client_list.add("sethcapital");
		client_list.add("knvssarma");
		client_list.add("ramainvest");
		client_list.add("ajaysingh");
		client_list.add("shrisaipraasad");
		client_list.add("gargcapitals");
		client_list.add("royinvestment");
		client_list.add("sflinvestments");
		client_list.add("labsalliances");
		client_list.add("kalpavrikshafinancial");
		client_list.add("jrassociates");
		client_list.add("thenextgengainer");
		client_list.add("virtuewealth");
		client_list.add("shayonam");
		client_list.add("jyotsnaa");
		client_list.add("rumtek");
		client_list.add("finvision");
		client_list.add("unicorn");

		return client_list;
	}
	
	public static int getDaysBetweenDates(Date startdate,Date enddate)
	{
		return (int)( (enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	public static double getAbsoluteReturns(double startvalue,double endvalue)
	{
		return ((endvalue - startvalue)/startvalue) * 100;
	}
	
	/*
     * Paramterized method to sort Map e.g. HashMap or Hashtable in Java
     * throw NullPointerException if Map contains null key
    */

    public static <K extends Comparable,V extends Comparable> Map<K,V> sortByKeys(Map<K,V> map)
    {
        List<K> keys = new LinkedList<K>(map.keySet());
        Collections.sort(keys);
     
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
        for(K key: keys){
            sortedMap.put(key, map.get(key));
        }

        return sortedMap;
    }
 
    /*
     * Java method to sort Map in Java by value e.g. HashMap or Hashtable
     * throw NullPointerException if Map contains null values
     * It also sort values even if they are duplicates
    */
    public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
     
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
     
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
     
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
     
        return sortedMap;
    }
    
    public static List<String> KarvyNeutralDividendTransactionType()
    {
    	List<String> list = new ArrayList<String>();
    	list.add("Gross Dividend");
    	list.add("Gross Dividend Rejection");
    	list.add("Gross Dividend Rejection Reversal");
    	list.add("Dividend Sweep Out");
    	list.add("Dividend Sweep Out Rej");
    	list.add("Dividend Sweep Out Rej.");
    	return list;
    }
    
    public static String SendHttpPost(String path,String parameters)
    {
   	 try 
   	 {        
            // Send the request
            URL url = new URL(path);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            
            //write parameters
            writer.write(parameters);
            writer.flush();
            
            // Get the response
            StringBuffer answer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            
            while ((line = reader.readLine()) != null) 
            {
                answer.append(line);
            }
            writer.close();
            reader.close();
            
            return answer.toString();
            
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return null;
    }
    
    public static List<Date> getAllDates(Date start,Date end) throws ParseException
	{
		List<Date> dates = new ArrayList<Date>();

		long interval = 24*1000 * 60 * 60; 
		long endTime = end.getTime(); 
		long curTime = start.getTime();
		
		
		while (curTime <= endTime) {
		    dates.add(new Date(curTime));
		    curTime += interval;
		}
		/*for(int i=0;i<dates.size();i++){
		    Date lDate =(Date)dates.get(i);
		    String ds = formatter.format(lDate);    
		}*/
		return dates;
	}
    
    /**
     * Method to parse a raw query string into parameter-value pairs and return
     * them in a {@code Map}.
     *
     * @param q The raw query string to be parsed.
     * @return {@code Map} containing parameter-value pairs.
     */
    public static Map <String, String> getParameterMap (String queryString) {
     
	 if (queryString.startsWith("?")) {
	      queryString = queryString.substring(1);
	    }
      // Initialize HashMap to store parameter-value pairs.
      Map<String, String> paramMap = new HashMap<String, String>();

      // Store parameter-value pairs in an array.
      String[] params = queryString.split("&");

      // Split parameter-value pairs and store in a HashMap.
      for (String s : params) {
        String[] ss = s.split("=");
        if (ss.length > 1) {
          paramMap.put(ss[0], ss[1]);
        } else if (ss.length == 1) {
          paramMap.put(ss[0], null);
        }
      }
      return paramMap;
    }
    
    public static double getDistanceBetweenLatLng(double lat1, double lng1, double lat2, double lng2) 
  	{
    	   
  	        double earthRadius = 3958.75;
  	        double dLat = Math.toRadians(lat2-lat1);
  	        double dLng = Math.toRadians(lng2-lng1);
  	        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
  	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
  	               Math.sin(dLng/2) * Math.sin(dLng/2);
  	        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  	        
  	        return   earthRadius * c * 1.60934;
  	}
    
    public static List<Date> getAllDates(String start,String end) throws ParseException
	{
		List<Date> dates = new ArrayList<Date>();

		String str_date = start;
		String end_date = end;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date  startDate = formatter.parse(str_date); 
		Date  endDate = formatter.parse(end_date);
		long interval = 24*1000 * 60 * 60; 
		long endTime = endDate.getTime(); 
		long curTime = startDate.getTime();
		
		
		while (curTime <= endTime) {
		    dates.add(new Date(curTime));
		    curTime += interval;
		}
		/*for(int i=0;i<dates.size();i++){
		    Date lDate =(Date)dates.get(i);
		    String ds = formatter.format(lDate);    
		}*/
		return dates;
	}
    
    public static String getIpAddr(HttpServletRequest request) 
    {      
		   //is client behind something?
		   String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		   if (ipAddress == null) 
		   {  
			   ipAddress = request.getRemoteAddr();  
		   }
		   return ipAddress;
	}  
   
	private static Pattern pattern;
	private static Matcher matcher;
 
	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean validateEmail(final String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();
	}
	
	 /***
     * The formatIntoHHMMSS method is used to convert integer seconds in String time.
     * @param secsIn
     * @return String
     */
    public static String formatIntoHHMMSS(int secsIn)
    {
	    int hours = secsIn / 3600;
	    int remainder = secsIn % 3600;
	    int minutes = remainder / 60;
	    int seconds = remainder % 60;
	
	    return ( (hours < 10 ? "0" : "") + hours
	    + ":" + (minutes < 10 ? "0" : "") + minutes
	    + ":" + (seconds< 10 ? "0" : "") + seconds );
    }
    
    public static boolean isValidUrl(String requestUrl,String page)
    {
    	try
    	{
        	if(page.equalsIgnoreCase("") || requestUrl.substring(requestUrl.indexOf(page),requestUrl.length()).equalsIgnoreCase(page))
    		{
    	         return true;
    		}
        	else
        	{
        	     return false;	
        	}
    	}
    	catch(Exception ex)
    	{
    		//ex.printStackTrace();
    		
    		return true;
    	}
    }
    
    public static String month_numberformat(String month)
    {
    	HashMap<String,String> month_map = new HashMap<String,String>();
		month_map.put("JAN","01");
		month_map.put("FEB","02");
		month_map.put("MAR","03");
		month_map.put("APR","04");
		month_map.put("MAY","05");
		month_map.put("JUN","06");
		month_map.put("JUL","07");
		month_map.put("AUG","08");
		month_map.put("SEP","09");
		month_map.put("OCT","10");
		month_map.put("NOV","11");
		month_map.put("DEC","12");
		
		String month_number = month_map.get(month);
		
    	return month_number;
    }
    
    public static String amc_name(String amc_code)
    {
    	HashMap<String,String> amc_name_map = new HashMap<String,String>();
		amc_name_map.put("02 ","AMFI");
		amc_name_map.put("B","Aditya Birla Sun Life Mutual Fund");
    	amc_name_map.put("128","Axis Mutual Fund");
    	amc_name_map.put("107","Baroda Mutual Fund");
    	amc_name_map.put("178","Baroda BNP Paribas Mutual Fund");
    	amc_name_map.put("116","Bank of India Mutual Fund");
    	amc_name_map.put("101","Canara Robeco Mutual Fund");
		amc_name_map.put("109","Deutsche Mutual Fund");
		amc_name_map.put("129","PGIM India Mutual Fund");
		amc_name_map.put("D","DSP Mutual Fund");
		amc_name_map.put("118","Edelweiss Mutual Fund");
		//amc_name_map.put("130","Navi Mutual Fund");
		amc_name_map.put("PLF","Navi Mutual Fund");
		amc_name_map.put("FTI","Franklin Templeton Mutual Fund");
		amc_name_map.put("110","Goldman Sachs Mutual Fund");
		amc_name_map.put("H","HDFC Mutual Fund");
		amc_name_map.put("O","HSBC Mutual Fund");
		amc_name_map.put("P","ICICI Prudential Mutual Fund");
		amc_name_map.put("135","IDBI Mutual Fund");
		amc_name_map.put("G","Bandhan Mutual Fund");
		amc_name_map.put("IF","360 ONE Mutual Fund");
		amc_name_map.put("125","Groww Mutual Fund");
		amc_name_map.put("I","ING Mutual Fund");
		amc_name_map.put("120","Invesco Mutual Fund");
		amc_name_map.put("105","JM Financial Mutual Fund");
		amc_name_map.put("J","JPMorgan Mutual Fund");
		amc_name_map.put("K","Kotak Mahindra Mutual Fund");
		amc_name_map.put("F","L&T Mutual Fund");
		amc_name_map.put("102","LIC Mutual Fund");
		amc_name_map.put("MM","Mahindra Manulife Mutual Fund");
		amc_name_map.put("117","Mirae Asset Mutual Fund");
		amc_name_map.put("115","Morgan Stanley Mutual Fund");
		amc_name_map.put("127","Motilal Oswal Mutual Fund");
		amc_name_map.put("A","PineBridge Mutual Fund");
		amc_name_map.put("PP","PPFAS Mutual Fund");
		amc_name_map.put("103","PRINCIPAL Mutual Fund");
		amc_name_map.put("166","Quant Mutual Fund");
		amc_name_map.put("123","Quantum Mutual Fund");
		amc_name_map.put("RMF","Nippon India Mutual Fund");
		amc_name_map.put("113","Sahara Mutual Fund");
		amc_name_map.put("L","SBI Mutual Fund");
		amc_name_map.put("SH","Shriram Mutual Fund");
		amc_name_map.put("176","Sundaram Mutual Fund");
		amc_name_map.put("T","Tata Mutual Fund");
		amc_name_map.put("104","Taurus Mutual Fund");
		amc_name_map.put("UK","Union Mutual Fund");
		amc_name_map.put("108","UTI Mutual Fund");
		amc_name_map.put("Y","WhiteOak Capital Mutual Fund");
		amc_name_map.put("BG","Birla Gold and Precious Metals");
		amc_name_map.put("RM","Reliance Money Precious Metals");
		amc_name_map.put("152","ITI Mutual Fund");
		amc_name_map.put("185","Trust Mutual Fund");
		amc_name_map.put("187","NJ Mutual Fund");
		amc_name_map.put("188","Samco Mutual Fund");
		amc_name_map.put("189","Bajaj Finserv Mutual Fund");
		
		String amc_name = amc_name_map.get(amc_code);
		
    	return amc_name;
    }
    
    /*
     * Java method to sort Map in Java by value in DESCENDING oRDER e.g. HashMap or Hashtable
     * throw NullPointerException if Map contains null values
     * It also sort values even if they are duplicates
    */
    public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValuesDescending(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
     
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {

            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
     
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
     
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
     
        return sortedMap;
    }
    
    public static Integer getCompanyDividendReinvestmentCode(String company_name)
    {
    	Integer code = 0;
    	//Code 0 Means, Dividend Declared Date Nav = Dividend Reinvest Nav
    	//Code 1 Means, Dividend Declared Date Nav - Dividend Value = Dividend Reinvest Nav
    	try
    	{
    		HashMap<String, Integer> company_map = new HashMap<String, Integer>();
    		company_map.put("Axis Mutual Fund", 0);
    		company_map.put("Deutsche Mutual Fund", 0);
    		company_map.put("PGIM India Mutual Fund", 0);
    		company_map.put("DSP Mutual Fund", 0);
    		company_map.put("Edelweiss Mutual Fund", 0);
    		company_map.put("Escorts Mutual Fund", 0);
    		company_map.put("Franklin Templeton Mutual Fund", 0);
    		company_map.put("Goldman Sachs Mutual Fund", 0);
    		company_map.put("HDFC Mutual Fund", 0);
    		company_map.put("IDBI Mutual Fund", 0);
    		company_map.put("Bandhan Mutual Fund", 0);
    		company_map.put("IIFCL Mutual Fund (IDF)", 0);
    		company_map.put("IIFL Mutual Fund", 0);
    		company_map.put("IL&amp;FS Mutual Fund (IDF)", 0);
    		company_map.put("Groww Mutual Fund", 0);
    		company_map.put("ING Mutual Fund", 0);
    		company_map.put("JM Financial Mutual Fund", 0);
    		company_map.put("JPMorgan Mutual Fund", 0);
    		company_map.put("Kotak Mahindra Mutual Fund", 0);
    		company_map.put("LIC Mutual Fund", 0);
    		company_map.put("Mahindra Manulife Mutual Fund", 0);
    		company_map.put("Morgan Stanley Mutual Fund", 0);
    		company_map.put("Motilal Oswal Mutual Fund", 0);
    		company_map.put("PineBridge Mutual Fund", 0);
    		company_map.put("PPFAS Mutual Fund", 0);
    		company_map.put("PRINCIPAL Mutual Fund", 0);
    		company_map.put("Quantum Mutual Fund", 0);
    		company_map.put("Nippon India Mutual Fund", 0);
    		company_map.put("Sahara Mutual Fund", 0);
    		company_map.put("SBI Mutual Fund", 0);
    		company_map.put("Shriram Mutual Fund", 0);
    		company_map.put("SREI Mutual Fund (IDF)", 0);
    		company_map.put("Tata Mutual Fund", 0);
    		company_map.put("Union KBC Mutual Fund", 0);
    		company_map.put("UTI Mutual Fund", 0);
    		company_map.put("Baroda Pioneer Mutual Fund", 1);
    		company_map.put("Birla Sun Life Mutual Fund", 1);
    		company_map.put("Baroda BNP Paribas Mutual Fund", 1);
    		company_map.put("Bank of India Mutual Fund", 1);
    		company_map.put("Canara Robeco Mutual Fund", 1);
    		company_map.put("HSBC Mutual Fund", 1);
    		company_map.put("ICICI Prudential Mutual Fund", 1);
    		company_map.put("Invesco Mutual Fund", 1);
    		company_map.put("L&T Mutual Fund", 1);
    		company_map.put("Mirae Asset Mutual Fund", 1);
    		company_map.put("Peerless Mutual Fund", 1);
    		company_map.put("Sundaram Mutual Fund", 1);
    		company_map.put("Taurus Mutual Fund", 1);
    		company_map.put("ITI Mutual Fund", 1);
    		
    		if(company_map.get(company_name) != null)
    		{
    			code = company_map.get(company_name);
    		}
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	return code;
    }
	
	public static TreeMap<Integer, Double> getPPFInterestRate()
    {	
		TreeMap<Integer, Double> interest_map = new TreeMap<Integer, Double>();
		
    	try
    	{
    		interest_map.put(1980, 8.0);
    		interest_map.put(1981, 8.5);
    		interest_map.put(1982, 8.5);
    		interest_map.put(1983, 9.0);
    		interest_map.put(1984, 9.5);
    		interest_map.put(1985, 10.0);
    		interest_map.put(1986, 12.0);
    		interest_map.put(1987, 12.0);
    		interest_map.put(1988, 12.0);
    		interest_map.put(1989, 12.0);
    		interest_map.put(1990, 12.0);
    		interest_map.put(1991, 12.0);
    		interest_map.put(1992, 12.0);
    		interest_map.put(1993, 12.0);
    		interest_map.put(1994, 12.0);
    		interest_map.put(1995, 12.0);
    		interest_map.put(1996, 12.0);
    		interest_map.put(1997, 12.0);
    		interest_map.put(1998, 12.0);
    		interest_map.put(1999, 12.0);
    		interest_map.put(2000, 11.0);
    		interest_map.put(2001, 9.5);
    		interest_map.put(2002, 9.0);
    		interest_map.put(2003, 8.0);
    		interest_map.put(2004, 8.0);
    		interest_map.put(2005, 8.0);
    		interest_map.put(2006, 8.0);
    		interest_map.put(2007, 8.0);
    		interest_map.put(2008, 8.0);
    		interest_map.put(2009, 8.0);
    		interest_map.put(2010, 8.0);
    		interest_map.put(2011, 8.6);
    		interest_map.put(2012, 8.8);
    		interest_map.put(2013, 8.7);
    		interest_map.put(2014, 8.7);
    		interest_map.put(2015, 8.7);
    		interest_map.put(2016, 8.1);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	return interest_map;
    }
    
    public static int getMonthValue(String key)
    {
    	int month = 0;
    	try
    	{
    		HashMap<String, Integer> month_map = new HashMap<String, Integer>();
    		month_map.put("Jan", 1);
    		month_map.put("Feb", 2);
    		month_map.put("Mar", 3);
    		month_map.put("Apr", 4);
    		month_map.put("May", 5);
    		month_map.put("Jun", 6);
    		month_map.put("Jul", 7);
    		month_map.put("Aug", 8);
    		month_map.put("Sep", 9);
    		month_map.put("Oct", 10);
    		month_map.put("Nov", 11);
    		month_map.put("Dec", 12);
    		
    		month = month_map.get(key);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	return month;
    }
    
    public static List<Integer> paginator(int page_id, int page_count)
    {
    	int beginPaginatorId = 1;  
        int endPaginatorId = 1; 
        
        List<Integer> paginator = new ArrayList<Integer>();
        
        if(page_count > 1)
        {
        	if(page_id <= 3)
            {
            	beginPaginatorId = 1;
            	endPaginatorId = page_id + 3 + (3 - page_id);
            }
            
            if(page_id > 3 && page_id < (page_count-3))
            {
            	beginPaginatorId = page_id - 3;
            	endPaginatorId = page_id + 3;
            }
            
            if(page_id >= (page_count-3))
            {
            	beginPaginatorId = page_id - 3 - ((3 + page_id) - page_count);
            	endPaginatorId = page_count;
            }
            
            if(beginPaginatorId < 0)
            {
            	beginPaginatorId = 1;
            }
            if(endPaginatorId > page_count)
            {
            	endPaginatorId = page_count;
            }
        }
        
        paginator.add(beginPaginatorId);
        paginator.add(endPaginatorId);
        
        return paginator;
    }

	public static List<String> getCompanies() {
		
		List<String> amc_list = new ArrayList<String>();
    	
    	try
    	{
    		amc_list.add("Canara Robeco Mutual Fund");
    		amc_list.add("SBI Mutual Fund");
    		amc_list.add("UTI Mutual Fund");
    		amc_list.add("DSP Mutual Fund");
    		amc_list.add("Edelweiss Mutual Fund");
    		amc_list.add("Bandhan Mutual Fund");
    		amc_list.add("Kotak Mahindra Mutual Fund");
    		amc_list.add("L&T Mutual Fund");
    		amc_list.add("Motilal Oswal Mutual Fund");
    		amc_list.add("Sundaram Mutual Fund");
    		amc_list.add("Tata Mutual Fund");
    		amc_list.add("Baroda BNP Paribas Mutual Fund");
    		amc_list.add("Franklin Templeton Mutual Fund");
    		amc_list.add("Invesco Mutual Fund");
    		amc_list.add("Mirae Asset Mutual Fund");
    		amc_list.add("PRINCIPAL Mutual Fund");
    		amc_list.add("Aditya Birla Sun Life Mutual Fund");
    		amc_list.add("Axis Mutual Fund");
    		amc_list.add("ICICI Prudential Mutual Fund");
    		amc_list.add("HDFC Mutual Fund");
    		amc_list.add("Nippon India Mutual Fund");
    		amc_list.add("HSBC Mutual Fund");
    		
			Collections.sort(amc_list);
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	return amc_list;
	}
    
    public static String getAMCName(String amc_code)
    {
    	HashMap<String,String> amc_name_map = new HashMap<String,String>();
    	amc_name_map.put("B","Aditya Birla Sun Life Mutual Fund");
    	amc_name_map.put("128","Axis Mutual Fund");
    	amc_name_map.put("107","Baroda Mutual Fund");
    	amc_name_map.put("178","Baroda BNP Paribas Mutual Fund");
    	amc_name_map.put("116","Bank of India Mutual Fund");
    	amc_name_map.put("101","Canara Robeco Mutual Fund");
		amc_name_map.put("109","Deutsche Mutual Fund");
		amc_name_map.put("129","PGIM India Mutual Fund");
		amc_name_map.put("D","DSP Mutual Fund");
		amc_name_map.put("118","Edelweiss Mutual Fund");
		//amc_name_map.put("130","Navi Mutual Fund");
		amc_name_map.put("PLF","Navi Mutual Fund");
		amc_name_map.put("FTI","Franklin Templeton Mutual Fund");
		amc_name_map.put("110","Goldman Sachs Mutual Fund");
		amc_name_map.put("H","HDFC Mutual Fund");
		amc_name_map.put("O","HSBC Mutual Fund");
		amc_name_map.put("P","ICICI Prudential Mutual Fund");
		amc_name_map.put("135","IDBI Mutual Fund");
		amc_name_map.put("G","Bandhan Mutual Fund");
		/*amc_name_map.put("","IIFCL Mutual Fund (IDF)");*/
		amc_name_map.put("IF","360 ONE Mutual Fund");
		/*amc_name_map.put("","IL&FS Mutual Fund (IDF)");*/
		amc_name_map.put("125","Groww Mutual Fund");
		amc_name_map.put("I","ING Mutual Fund");
		amc_name_map.put("120","Invesco Mutual Fund");
		amc_name_map.put("105","JM Financial Mutual Fund");
		amc_name_map.put("J","JPMorgan Mutual Fund");
		amc_name_map.put("K","Kotak Mahindra Mutual Fund");
		amc_name_map.put("F","L&T Mutual Fund");
		amc_name_map.put("102","LIC Mutual Fund");
		amc_name_map.put("MM","Mahindra Manulife Mutual Fund");
		amc_name_map.put("117","Mirae Asset Mutual Fund");
		amc_name_map.put("115","Morgan Stanley Mutual Fund");
		amc_name_map.put("127","Motilal Oswal Mutual Fund");
		amc_name_map.put("A","PineBridge Mutual Fund");
		amc_name_map.put("PP","PPFAS Mutual Fund");
		amc_name_map.put("103","PRINCIPAL Mutual Fund");
		amc_name_map.put("166","Quant Mutual Fund");
		amc_name_map.put("123","Quantum Mutual Fund");
		amc_name_map.put("RMF","Nippon India Mutual Fund");
		amc_name_map.put("113","Sahara Mutual Fund");
		amc_name_map.put("L","SBI Mutual Fund");
		amc_name_map.put("SH","Shriram Mutual Fund");
		/*amc_name_map.put("","SREI Mutual Fund (IDF)");*/
		amc_name_map.put("176","Sundaram Mutual Fund");
		amc_name_map.put("T","Tata Mutual Fund");
		amc_name_map.put("104","Taurus Mutual Fund");
		amc_name_map.put("UK","Union Mutual Fund");
		amc_name_map.put("108","UTI Mutual Fund");
		amc_name_map.put("Y","WhiteOak Capital Mutual Fund");
		amc_name_map.put("152","ITI Mutual Fund");
		amc_name_map.put("185","Trust Mutual Fund");
		amc_name_map.put("187","NJ Mutual Fund");
		amc_name_map.put("188","Samco Mutual Fund");
		amc_name_map.put("189","Bajaj Finserv Mutual Fund");
		
		String amc_name = amc_name_map.get(amc_code);
		if(amc_name == null) {amc_name="";}
		
    	return amc_name;
    }

	public static String getMonthNumber(String month)
    {
    	HashMap<String,String> amc_name_map = new HashMap<String,String>();
    	amc_name_map.put("January","01");
    	amc_name_map.put("February","02");
    	amc_name_map.put("March","03");
    	amc_name_map.put("April","04");
    	amc_name_map.put("May","05");
    	amc_name_map.put("June","06");
		amc_name_map.put("July","07");
		amc_name_map.put("August","08");
		amc_name_map.put("September","09");
		amc_name_map.put("October","10");
		amc_name_map.put("November","11");
		amc_name_map.put("December","12");
		
		String month_no = amc_name_map.get(month);
		
    	return month_no;
    }
    
    public static String getCategoryNameShort(String category)
    {
    	HashMap<String,String> category_map = new HashMap<String,String>();
    	category_map.put("Childrens Fund","CHILD");
    	category_map.put("Close ended equity scheme","CL-EQ");
    	category_map.put("Close ended thematic scheme","CL-THEME");
    	category_map.put("Debt: Banking and PSU","DT-BK-PSU");
    	category_map.put("Debt: Corporate Bond","DT-CB");
    	category_map.put("Debt: Credit Risk","DT-CR");
    	category_map.put("Debt: Dynamic Bond","DT-DB");	
    	category_map.put("Debt: Floater","DT-FLO");
    	category_map.put("Debt: FMP","DT-FMP");
    	category_map.put("Debt: Gilt","DT-GILT");
    	category_map.put("Debt: Gilt Fund with 10 year constant duration","DT-GILT-10");
    	category_map.put("Debt: Liquid","DT-LIQ");
    	category_map.put("Debt: Long Duration","DT-LONG-D");
    	category_map.put("Debt: Low Duration","DT-LOW-D");
    	category_map.put("Debt: Medium Duration","DT-MD");
    	category_map.put("Debt: Medium to Long Duration","DT-M-LD");
    	category_map.put("Debt: Money Market","DT-MM");
    	category_map.put("Debt: Overnight","DT-OVENGT");
    	category_map.put("Debt: Short Duration","DT-SD");
    	category_map.put("Debt: Ultra Short Duration","DT-USD");
    	category_map.put("Equity: Contra","EQ-CONTRA");
    	category_map.put("Equity: Dividend Yield","EQ-DIV-Y");
    	category_map.put("Equity: ELSS","EQ-ELSS");
    	category_map.put("Equity: Focused","EQ-FOCUS");
    	category_map.put("Equity: Large and Mid Cap","EQ-L-MC");
    	category_map.put("Equity: Large Cap","EQ-LC");	
    	category_map.put("Equity: Mid Cap","EQ-MID");
    	category_map.put("Equity: Multi Cap","EQ-MLC");
    	category_map.put("Equity: Sectoral-Banking and Financial Services","EQ-BANK");
    	category_map.put("Equity: Sectoral-FMCG","EQ-FMCG");
    	category_map.put("Equity: Sectoral-Infrastructure","EQ-INFRA");
    	category_map.put("Equity: Sectoral-Pharma and Healthcare","EQ-PHARMA");
    	category_map.put("Equity: Sectoral-Technology","EQ-IT");
    	category_map.put("Equity: Small Cap","EQ-SC");
    	category_map.put("Equity: Thematic-Consumption","EQ-CONS");
    	category_map.put("Equity: Thematic-Energy","EQ-ENERGY");	
    	category_map.put("Equity: Thematic-International","EQ-INTL");
    	category_map.put("Equity: Thematic-MNC","EQ-MNC");
    	category_map.put("Equity: Thematic-Others","EQ-THE-O");
    	category_map.put("Equity: Thematic-PSU","EQ-PSU");
    	category_map.put("Equity: Value","EQ-VALUE");
    	category_map.put("ETFs","ETFs");
    	category_map.put("Fund of Funds-Domestic","FOF-DOM");
    	category_map.put("Fund of Funds-Overseas","FOF-OV");
    	category_map.put("Hybrid: Aggressive","HY-AGR");
    	category_map.put("Hybrid: Arbitrage","HY-ARB");
    	category_map.put("Hybrid: Conservative","HY-CON");
    	category_map.put("Hybrid: Dynamic Asset Allocation","HY-DAA");
    	category_map.put("Hybrid: Equity Savings","HY-EQ-S");
    	category_map.put("Hybrid: Multi Asset Allocation","HY-MAA");
    	category_map.put("Index Fund","INDEX");
    	category_map.put("Retirement Fund","RETIREMENT");
		
		String category_code = category_map.get(category);
		if(category_code == null){
			category_code = "";
		}
    	return category_code;
    }
    
    /*public static String getStateNameByPincode(String pincode){

        String state = "";

        //Andaman and Nicobar Islands, Andhra Pradesh, ArunachalPradesh, Assam,
        // Bihar, Chandigarh, Chhattisgarh, Chattisgarh, DadraandNagar, Dadra & Nagar Haveli,
        // Diu-Daman, Delhi, Goa, Gujarat, Haryana, HimachalPradesh, Himachal Pradesh,
        // JammuKashmir, Jammu & Kashmir, Jharkhand, Karnataka, Kerala, Ladakh, Lakshadweep,
        // Madhya Pradesh, Maharashtra, Manipur, Meghalaya, Mizoram, Nagaland, Odisha, Puducherry,
        // Pondicherry, Punjab, Rajasthan, Sikkim, TamilNadu, Tamil Nadu, Telangana, Tripura, Uttar Pradesh, Uttarakhand, West Bengal

        if(pincode.startsWith("11"))
        {
          state = "Delhi";
        }
        else if(pincode.startsWith("12") || pincode.startsWith("13"))
        {
          state = "Haryana";
        }
        else if(pincode.startsWith("14") || pincode.startsWith("15"))
        {
          state = "Punjab";
        }
        else if(pincode.startsWith("16"))
        {
          state = "Chandigarh";
        }
        else if(pincode.startsWith("17") )
        {
          state = "Himachal Pradesh";
        }
        else if(pincode.startsWith("18") || pincode.startsWith("19") )
        {
          state = "Jammu & Kashmir";
        }
        else if(pincode.startsWith("20") || pincode.startsWith("21") || pincode.startsWith("22") || pincode.startsWith("23") || pincode.startsWith("24") || pincode.startsWith("25") || pincode.startsWith("26") || pincode.startsWith("27") || pincode.startsWith("28"))
        {
          state = "Uttar Pradesh";
        }
        else if(pincode.startsWith("30") || pincode.startsWith("31") || pincode.startsWith("32") || pincode.startsWith("33") || pincode.startsWith("34"))
        {
          state = "Rajasthan";
        }

        else if(pincode.startsWith("36") || pincode.startsWith("37") || pincode.startsWith("38") || pincode.startsWith("39") )
        {
          state = "Gujarat";
        }

        else if(pincode.startsWith("40") || pincode.startsWith("41") || pincode.startsWith("42") || pincode.startsWith("43") || pincode.startsWith("44"))
        {
          state = "Maharashtra";
        }

        else if(pincode.startsWith("45") || pincode.startsWith("46") || pincode.startsWith("47") || pincode.startsWith("48"))
        {
          state = "Madhya Pradesh";
        }
        
        else if(pincode.startsWith("49"))
        {
          state = "Chattisgarh";
        }

        else if(pincode.startsWith("50"))
        {
          state = "Telangana" ;
        }
        
        else if(pincode.startsWith("51") || pincode.startsWith("52") || pincode.startsWith("53"))
        {
          state = "Andhra Pradesh";
        }

        else if(pincode.startsWith("56") || pincode.startsWith("57") || pincode.startsWith("58") || pincode.startsWith("59") )
        {
          state = "Karnataka" ;
        }

        else if(pincode.startsWith("60") || pincode.startsWith("61") || pincode.startsWith("62") || pincode.startsWith("63") || pincode.startsWith("64"))
        {
          state = "TamilNadu";
        }

        else if(pincode.startsWith("67") || pincode.startsWith("68") || pincode.startsWith("69"))
        {
          state = "Kerala";
        }

        else if(pincode.startsWith("70") || pincode.startsWith("71") || pincode.startsWith("72") || pincode.startsWith("73") || pincode.startsWith("74"))
        {
          state = "West Bengal";
        }

        else if(pincode.startsWith("75") || pincode.startsWith("76") || pincode.startsWith("77") )
        {
          state = "Odisha";
        }

        else if(pincode.startsWith("78") )
        {
          state = "Assam";
        }

        else if(pincode.startsWith("79") )
        {
          state = "North Eastern";
        }

        else if(pincode.startsWith("80") || pincode.startsWith("81") || pincode.startsWith("82") || pincode.startsWith("83") || pincode.startsWith("84") || pincode.startsWith("85"))
        {
          state = "Bihar & Jharkhand";
        }
        else if(pincode.startsWith("90") || pincode.startsWith("91") || pincode.startsWith("92") || pincode.startsWith("93") || pincode.startsWith("94") || pincode.startsWith("95"))
        {
          state = "Army Postal Service (APS)";
        }

        return state;

      }*/
    
	public static List<List<String>> getRTATransactionType()
    {
		List<String> cams_switch_in_list = new ArrayList<String>();
		cams_switch_in_list.add("Switch In");
		cams_switch_in_list.add("NFO SI");
		cams_switch_in_list.add("STP In");
		cams_switch_in_list.add("TICOB");
		cams_switch_in_list.add("TIX");
		cams_switch_in_list.add("TIXT");
		cams_switch_in_list.add("Transfer In");
		
		List<String> cams_switch_out_list = new ArrayList<String>();
		cams_switch_out_list.add("Switch Out");
		cams_switch_out_list.add("Full Switch Out");
		cams_switch_out_list.add("Partial Switch Out");
		cams_switch_out_list.add("TOCOB");
		cams_switch_out_list.add("STP Out");
		cams_switch_out_list.add("TOX");
		cams_switch_out_list.add("TOXT");
		cams_switch_out_list.add("Transfer Out");
		
		List<String> cams_dividend_list = new ArrayList<String>();
		cams_dividend_list.add("Dividend Reinvest");
		cams_dividend_list.add("BONUS");
		
		List<String> karvy_switch_in_list = new ArrayList<String>();
		karvy_switch_in_list.add("Lateral Shift In");
		karvy_switch_in_list.add("Lat. Shift In Rej.");
		karvy_switch_in_list.add("Lat. Shift In Rej. Reversal");
		karvy_switch_in_list.add("S T P In");
		karvy_switch_in_list.add("S T P In Rej");
		karvy_switch_in_list.add("S T P In Rej Reversal");
		karvy_switch_in_list.add("Switch Over In");
		karvy_switch_in_list.add("Swit. Over In Rej.");
		karvy_switch_in_list.add("Swit. Over In Rej. Reversal");
		karvy_switch_in_list.add("STRIP In");
		karvy_switch_in_list.add("STRIP In Rejection");
		karvy_switch_in_list.add("Transmission In");
		karvy_switch_in_list.add("Transmission In Rejection");
		karvy_switch_in_list.add("Demat Transfer In");
		karvy_switch_in_list.add("Demat Transfer in Rej");
		karvy_switch_in_list.add("Asset Allocation In");
		karvy_switch_in_list.add("Asset Allocation In Rejection");
		
		List<String> karvy_switch_out_list = new ArrayList<String>();
		karvy_switch_out_list.add("Lateral Shift Out");
		karvy_switch_out_list.add("Lat. Shift Out Rej.");
		karvy_switch_out_list.add("Lat. Shift Out Rej. Reversal");
		karvy_switch_out_list.add("S T P Out");
		karvy_switch_out_list.add("S T P Out Rej");
		karvy_switch_out_list.add("S T P Out Rej Reversal");
		karvy_switch_out_list.add("Switch Over Out");
		karvy_switch_out_list.add("Swit. Over Out Rej.");
		karvy_switch_out_list.add("Swit. Over Out Rej. Reversal");
		karvy_switch_out_list.add("STRIP Out");
		karvy_switch_out_list.add("STRIP Out Rejection");
		karvy_switch_out_list.add("Transmission Out");
		karvy_switch_out_list.add("Transmission Out Rejection");
		karvy_switch_out_list.add("Demat Transfer Out");
		karvy_switch_out_list.add("Demat Transfer Out Rej");
		karvy_switch_out_list.add("Demat Transfer Out Rej Reversal");
		karvy_switch_out_list.add("Asset Allocation Out");
		karvy_switch_out_list.add("Asset Allocation Out Rejection");
		
		List<String> karvy_dividend_list = new ArrayList<String>();
		karvy_dividend_list.add("Div. Reinvestment");
		karvy_dividend_list.add("ReInvestment Rejection");
		karvy_dividend_list.add("ReInvestment Rejection Reversal");
		karvy_dividend_list.add("Dividend Sweep In");
		karvy_dividend_list.add("Dividend Sweep In Rej.");
		karvy_dividend_list.add("Bonus Units");
		karvy_dividend_list.add("Bonus Rejection");
		karvy_dividend_list.add("Segregated Units");
		
		List<List<String>> master_list = new ArrayList<List<String>>();
		master_list.add(cams_switch_in_list);
		master_list.add(cams_switch_out_list);
		master_list.add(cams_dividend_list);
		
		master_list.add(karvy_switch_in_list);
		master_list.add(karvy_switch_out_list);
		master_list.add(karvy_dividend_list);
		
    	return master_list;
    }
}
