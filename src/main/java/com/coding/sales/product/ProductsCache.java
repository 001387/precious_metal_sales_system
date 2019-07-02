package com.coding.sales.product;
/**
 *@author yangshen
 * @date  2019年7月2日
 */

import java.util.HashMap;
import java.util.Map;

import com.coding.constant.ProductItemConstant;

public class ProductsCache {
	
	public static Map<String , Product> products = new HashMap<String, Product>();

	{
//		products.put("001001", new Product("世园会五十国钱币册", "001001", "册", 1080.00, null , null));
		
	}
	
	public static Map<String, String> FULL_SUB_RULE = new HashMap<String, String>();
	{
		FULL_SUB_RULE.put(ProductItemConstant.FullSubRule.FULL_3_SUB_1, "第3件半价，满3送1");
		FULL_SUB_RULE.put(ProductItemConstant.FullSubRule.FULL_3000_SUB_350, "每满3000元减350, 每满2000减30，每满1000减10");
		FULL_SUB_RULE.put(ProductItemConstant.FullSubRule.FULL_2000_SUB_30, "每满2000减30，每满1000减10");
	}
	
}
