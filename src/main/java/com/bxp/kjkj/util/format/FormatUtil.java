package com.bxp.kjkj.util.format;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
	public static String formatDate(Long time){
		if(time == null)
			return "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date(time));
	}
	
	public static String formaTime(Long time){
		if(time == null)
			return "";
		DateFormat format = new SimpleDateFormat("HH:ss:mm");
		return format.format(new Date(time));
	}
	
	public static String formatDateTime(Long time){
		if(time == null)
			return "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm	");
		return format.format(new Date(time));
	}
	
	public static final String formatMoney(Double money){
		if(money == null) return "非法格式";
		 DecimalFormat df = new DecimalFormat("#.00");
	     return df.format(money);
	}
}
