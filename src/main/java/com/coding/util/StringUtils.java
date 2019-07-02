package com.coding.util;
/**
 *@author yangshen
 * @date  2019年7月2日
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	public static boolean isEmpty(String string) {
		return string == null || string.length()==0;
	}
	public static boolean isNotEmpty(String string) {
		return !isEmpty(string);
	}
	
	public static java.util.Date formateDate(String yyyyMMdd) {
		 SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
	        //必须捕获异常
		 Date date = new Date();
		 
	        try {
	            date= sDateFormat.parse(yyyyMMdd);
	            System.out.println(date);
	        } catch(Exception px) {
	            px.printStackTrace();
	        }
		return date;
	}
}
