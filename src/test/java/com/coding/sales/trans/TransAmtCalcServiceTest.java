package com.coding.sales.trans;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.product.Product;

/**
 *@author yangshen
 * @date  2019年7月2日
 */
public class TransAmtCalcServiceTest {
	
		@Test
		public void should_return_total_price_when_buy_the_product() {
			TransAmtCalcService transAmtCalcService = new TransAmtCalcService();
			
			OrderItemCommand orderItemCommand = new OrderItemCommand("001001", new BigDecimal(2.0));
			
			 Product product = new Product();
			 product.setPrice(1000.00);
			 product.setProductId("001001");
			 
			assertEquals(String.format("%.2f", 2*1000.00), transAmtCalcService.calculateTotalPrice(orderItemCommand, product));
		}
}
