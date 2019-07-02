package com.coding.sales.trans;

import java.math.BigDecimal;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.product.Product;
import com.coding.sales.product.ProductsCache;
/**
 *@author yangshen
 * @date  2019年7月2日
 */
public class TransAmtCalcService {
	
	public BigDecimal calcAmt(OrderItemCommand orderItemCommand ) {
		
		String productId = orderItemCommand.getProduct();
		
		Product product = ProductsCache.products.get(productId);
		
		return null;
	}
}
