package com.coding.util;
/**
 *@author yangshen
 * @date  2019年7月2日
 */

import java.sql.Date;

public class StringUtils {

	public static boolean isEmpty(String string) {
		return string == null || string.length()==0;
	}
	public static boolean isNotEmpty(String string) {
		return !isEmpty(string);
	}
	
	public static Date formateDate(String yyyyMMdd) {
		return null;
		
	}
}
