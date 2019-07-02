package com.coding.sales.trans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;

import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.members.MemberInfo;
import com.coding.sales.members.Members;
import com.coding.sales.product.Product;
import com.coding.sales.product.ProductsCache;

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
		
		@Test
		public void should_add_bonus_points_when_buy_the_product_use_account_blance() {
			
			OrderItemCommand orderItemCommand = new OrderItemCommand("001001", new BigDecimal(2.0));
			
			PaymentCommand paymentCommand = new PaymentCommand("余额支付", new BigDecimal(9800));
			Product product = ProductsCache.products.get("001001");
			
			MemberInfo memberInfo =  Members.getMemberInfo("6236609999");
			int bonusPoints = memberInfo.getBonusPoints();
			
			TransAmtCalcService amtCalcService = new TransAmtCalcService();
			
			
			 amtCalcService.updateMemberBonusPoints(memberInfo,product,paymentCommand,orderItemCommand,"");
			
			assertTrue(memberInfo.getBonusPoints()>bonusPoints);
		}
		
		@Test
		public void should_have_a_discount_when_but_product_use_the_discount_coupon() {
			
			OrderItemCommand orderItemCommand = new OrderItemCommand("001002", new BigDecimal(2.0));
			
			PaymentCommand paymentCommand = new PaymentCommand("余额支付", new BigDecimal(9800));
			
			Product product = ProductsCache.products.get("001002");
			
			MemberInfo memberInfo =  Members.getMemberInfo("6236609999");
			
			TransAmtCalcService amtCalcService = new TransAmtCalcService();
			
			Map<String, Object> map = amtCalcService.updateMemberBonusPoints(memberInfo, product, paymentCommand, orderItemCommand,"9折券");
			Double totprice = (Double) map.get("totalprice");
			assertTrue(totprice/(2*0.9*1380)==1);
		}
}
