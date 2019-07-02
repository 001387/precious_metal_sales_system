package com.coding.sales.product;
/**
 *@author yangshen
 * @date  2019年7月2日
 */

import java.util.HashMap;
import java.util.Map;

import com.coding.constant.CommonConstant;

public class ProductsCache {
	
	public static Map<String , Product> products = new HashMap<String, Product>();

	static{
		products.put("001001", new Product("世园会五十国钱币册", "001001", CommonConstant.ProductUnit.PRD_UNIT_VOLUM, 998.00, null , null));
		products.put("001002", new Product("2019北京世园会纪念银章大全40g", "001002", CommonConstant.ProductUnit.PRD_UNIT_BOX, 1380.00, "可使用9折打折券" , null));
		products.put("003001", new Product("招财进宝", "003001", CommonConstant.ProductUnit.PRD_UNIT_A, 1580.00, "可使用95折打折券" , null));
		products.put("003002", new Product("水晶之恋", "003002", CommonConstant.ProductUnit.PRD_UNIT_A, 980.00, null, "第3件半价，满3送1"));
		products.put("002002", new Product("中国经典钱币套装", "002002", CommonConstant.ProductUnit.PRD_UNIT_SET, 998.00, null , "每满2000减30，每满1000减10"));
		products.put("002001", new Product("守扩之羽比翼双飞4.8g", "002001", CommonConstant.ProductUnit.PRD_UNIT_A, 1080.00, "可使用95折打折券" , "第3件半价，满3送1"));
		products.put("002003", new Product("中国银象棋12g", "002003", CommonConstant.ProductUnit.PRD_UNIT_SET, 698.00, "可使用9折打折券" , "每满3000元减350, 每满2000减30，每满1000减10"));
	}
	
	public static Map<String, String> FULL_SUB_RULE = new HashMap<String, String>();
	{
		FULL_SUB_RULE.put(CommonConstant.FullSubRule.FULL_3_SUB_1, "第3件半价，满3送1");
		FULL_SUB_RULE.put(CommonConstant.FullSubRule.FULL_3000_SUB_350, "每满3000元减350, 每满2000减30，每满1000减10");
		FULL_SUB_RULE.put(CommonConstant.FullSubRule.FULL_2000_SUB_30, "每满2000减30，每满1000减10");
	}
	
}
