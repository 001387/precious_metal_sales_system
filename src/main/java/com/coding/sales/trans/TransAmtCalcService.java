package com.coding.sales.trans;


import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.product.Product;
/**
 *@author yangshen
 * @date  2019年7月2日
 */
public class TransAmtCalcService {
	

	public String calculateTotalPrice(OrderItemCommand orderItemCommand, Product product) {
		
		Double totalPrice = orderItemCommand.getAmount().doubleValue() * product.getPrice().doubleValue();
		
		return String.format("%.2f", totalPrice);
	}
}
