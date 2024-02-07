package com.adv.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AmfiCronGeneralFunctions {
	
	
	public static double getDiffYears(Date date1, Date date2) 
	{
		long diff = date2.getTime() - date1.getTime();
		long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	    //System.out.println ("Days: " + days);
		double years = (double)days / (double)365;
		return years;
	}
	
	public static double getDiffDays(Date date1, Date date2) 
	{
		long diff = date2.getTime() - date1.getTime();
		double days  = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	    //System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	    return days;
	}
	
	public static double getDiffDaysForDivAdjustedNav(Date lesserDate, Date greaterDate)
	{
		double diffInDays = ( (lesserDate.getTime() - greaterDate.getTime()) / 86400000);
		return diffInDays;
	}
}
