package com.coding.sales.trans;


import com.coding.constant.ProductItemConstant;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.members.MemberInfo;
import com.coding.sales.members.Members;
import com.coding.sales.product.Product;
import com.coding.util.StringUtils;
/**
 *@author yangshen
 * @date  2019年7月2日
 */
public class TransAmtCalcService {
	

	public String calculateTotalPrice(OrderItemCommand orderItemCommand, Product product) {
		
		Double totalPrice = orderItemCommand.getAmount().doubleValue() * product.getPrice().doubleValue();
		
		return String.format("%.2f", totalPrice);
	}
	
	 public Double  updateMemberBonusPoints(MemberInfo memberInfo, Product product, PaymentCommand paymentCommand, OrderItemCommand orderItemCommand, String discount){
			Double totalPrice = orderItemCommand.getAmount().doubleValue() * product.getPrice();
			
			String level = memberInfo.getLevel();
			if ( isCanDiscount(product, discount)) {
				if (ProductItemConstant.ProdcutDiscount.DISCOUNT_90.equals(discount)) {
					totalPrice = totalPrice * 0.9;
				}else if (ProductItemConstant.ProdcutDiscount.DISCOUNT_95.equals(discount)) {
					totalPrice = totalPrice * 0.95;
				}
			}
			Double points = 0.0;
			if ( null == Members.memberCardLevel.get(level)) {
				throw new IllegalArgumentException("卡级别错误");
			}
			points = totalPrice * Members.memberCardLevel.get(level);
			
			memberInfo.addBonusProints(points);
			return totalPrice;
			
	 }
	 
	 private boolean isCanDiscount(Product product,String discount) {
		return  StringUtils.isNotEmpty(product.getDiscount()) &&  StringUtils.isNotEmpty(discount) && product.getDiscount().equals(discount);
	}
}
