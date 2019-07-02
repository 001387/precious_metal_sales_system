package com.coding.sales.trans;


import com.coding.constant.ProductItemConstant;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.members.MemberInfo;
import com.coding.sales.members.Members;
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
	
	 public MemberInfo  updateMemberBonusPoints(MemberInfo memberInfo, Product product, PaymentCommand paymentCommand, OrderItemCommand orderItemCommand){
			Double totalPrice = orderItemCommand.getAmount().doubleValue() * product.getPrice();
			
			String level = memberInfo.getLevel();
			Double points = 0.0;
			if ( null == Members.memberCardLevel.get(level)) {
				throw new IllegalArgumentException("卡级别错误");
			}
			points = totalPrice * Members.memberCardLevel.get(level);
			
			memberInfo.addBonusProints(points);
			return memberInfo;
			
	 }
}
