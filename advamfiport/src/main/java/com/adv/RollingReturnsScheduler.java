package com.adv;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.adv.amfi.dao.RollingReturnsDAO;
import com.adv.amfi.repository.SchemeMappingRepository;
import com.adv.amfi.repository.SchemeRollingReturnsRepository;
import com.itextpdf.html2pdf.HtmlConverter;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Configuration
@EnableScheduling
@Transactional
public class RollingReturnsScheduler {

	static int rollingReturnsRowCount = 0;
	static boolean isRollingReturnsRunning = false;
	static int rollingReturnsSchemeMappingCount = 0;
	
	@Autowired
	private SchemeMappingRepository schemeMappingRepository;
	
	@Autowired
	private SchemeRollingReturnsRepository schemeRollingReturnsRepository;
	
	@Autowired
	@Qualifier("amfiEntityManagerFactory")
	private EntityManager amfiSession;
	
	@Autowired
	RollingReturnsDAO rollingReturnsDAO;
	
	//second, minute, hour, day of month, month, day(s) of week
	//@Scheduled(cron = "0 8 14 1/1 * ?")
	//@Scheduled(fixedDelay = 1000000000, initialDelay = 5000)
	/*public void startRollingReturns() {
		
		System.out.println("--------------------------------------->");
		System.out.println("Starting SchemeRollingReturns at " + new Date());

		amfiSession.createNativeQuery("truncate table scheme_rolling_returns").executeUpdate();
		
		System.out.println("Truncated SchemeRollingReturns at " + new Date());
		
		String sql = "select scheme_company,scheme_advisorkhoj_category,scheme_amfi,"
				+ "scheme_amfi_code,url,scheme_amfi_common,scheme_amfi_short_name,scheme_plan_type from scheme_mapping "
				+ "where active = 1 and scheme_amfi_code != '' and scheme_amfi_code is not null "
				+ "and scheme_amfi not like '%Institutiona%' and scheme_amfi not like '%bonus%' "
				+ "order by scheme_amfi asc";
		
		rollingReturnsSchemeMappingCount = amfiSession.createNativeQuery(sql).getResultList().size();
		
		System.out.println("RollingReturnsSchemeMappingCount = " + rollingReturnsSchemeMappingCount);
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
		       
		    	if(!isRollingReturnsRunning) {
					//System.out.println("rollingReturnsRowCount = " + (rollingReturnsRowCount + 1));
					isRollingReturnsRunning = true;
					rollingReturnsDAO.updateSchemeRollingReturns(rollingReturnsRowCount);			
					isRollingReturnsRunning = false;
					rollingReturnsRowCount++;
					
					if(rollingReturnsRowCount >= rollingReturnsSchemeMappingCount) {
						t.cancel();
						
						//to set it to zero for next scheduler iteration
						rollingReturnsRowCount = 0;
						
						System.out.println("Ending SchemeRollingReturns at " + new Date());
						System.out.println("--------------------------------------->");
					}
					
				}
		    	
		    }
		}, 0, 1000);
		
		
		
	}*/
	
	/*@Scheduled(fixedDelay = 1000, initialDelay = 10000)
    public void runSchemeRollingReturns() {

	
    }
    
    public void testRollingReturns() throws IOException {
		
		System.out.println();
		
		HtmlConverter.convertToPdf(new File("./pdf-input.html"),new File("demo-html.pdf"));
    	
    }*/
	
}
