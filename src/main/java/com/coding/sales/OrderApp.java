package com.coding.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.coding.constant.CommonConstant;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.members.MemberInfo;
import com.coding.sales.members.Members;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;
import com.coding.sales.product.ProductsCache;
import com.coding.sales.trans.TransAmtCalcService;
import com.coding.util.StringUtils;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
        }

        String jsonFileName = args[0];
        String txtFileName = args[1];

        String orderCommand = FileUtils.readFromFile(jsonFileName);
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand) {
        OrderCommand command = OrderCommand.from(orderCommand);
        OrderRepresentation result = checkout(command);
        
        return result.toString();
    }

    @SuppressWarnings("null")
	OrderRepresentation checkout(OrderCommand command) {
    	OrderRepresentation result = new OrderRepresentation(); 
    	TransAmtCalcService transAmtCalcService = new TransAmtCalcService();
    	List<OrderItemCommand> orderItemCommands =  command.getItems();
    	
    	List<PaymentCommand> paymentCommands = command.getPayments();
    	List<String> discounts  = command.getDiscounts();
    	String discount = null;
    	
    	for (String string : discounts) {
    		discount = string;
		}
    	MemberInfo memberInfo = Members.getMemberInfo(command.getMemberId());
    	String oldLevel = memberInfo.getLevel();
    	int oldBonusPoints = memberInfo.getBonusPoints();
    	PaymentCommand pCommand = null;
    	for (PaymentCommand paymentCommand : paymentCommands) {
    		pCommand = paymentCommand;
		}
    	Double totalPrice =     0.0;
    	Double discountDouble = 0.0;
    	
    	List<OrderItemRepresentation> orderItemRepresentations = new ArrayList<OrderItemRepresentation>();
    	List<DiscountItemRepresentation> discountItemRepresentations = new ArrayList<DiscountItemRepresentation>();
    	List<PaymentRepresentation> paymentRepresentations = new ArrayList<PaymentRepresentation>();
    	List<String> discountCards = new ArrayList<String>();
    	
    	for (OrderItemCommand orderItemCommand : orderItemCommands) {
    		Map<String, Object> resultMap = transAmtCalcService.updateMemberBonusPoints(memberInfo, ProductsCache.products.get(orderItemCommand.getProduct()), pCommand, orderItemCommand, discount);
    		orderItemRepresentations.add((OrderItemRepresentation) resultMap.get(CommonConstant.objectName.OBJECT_ORDERITEMREPRESENTATION));
    		discountItemRepresentations.add((DiscountItemRepresentation) resultMap.get(CommonConstant.objectName.OBJECT_DISCOUNTITEMREPRESENTATION));
    		paymentRepresentations.add((PaymentRepresentation) resultMap.get(CommonConstant.objectName.OBJECT_PAYMENTREPRESENTATION));
    		if (((PaymentRepresentation)resultMap.get("paymentRepresentation")).getAmount().intValue()>0) {
    			paymentRepresentations.add((PaymentRepresentation) resultMap.get("paymentRepresentation"));
			}
    		discountCards.add((String) resultMap.get("discountCard"));
    		totalPrice = totalPrice+(Double)resultMap.get("totalPrice");
    		discountDouble = discountDouble+(Double)resultMap.get("discountDouble");
		}

    	result.setDiscountCards(discountCards);
    	result.setOrderId(command.getOrderId());
    	result.setCreateTime(StringUtils.formateDate(command.getCreateTime()));
    	result.setMemberNo(command.getMemberId());
    	result.setMemberPoints(memberInfo.getBonusPoints());
    	result.setMemberName(memberInfo.getName());
    	result.setNewMemberType(memberInfo.getLevel());
    	result.setOldMemberType(oldLevel);
    	result.setDiscounts(discountItemRepresentations);
    	result.setPayments(paymentRepresentations);
    	result.setItems(orderItemRepresentations);
    	result.setTotalPrice(new BigDecimal(totalPrice));
    	result.setTotalDiscountPrice(new BigDecimal(discountDouble));
    	result.setReceivables(new BigDecimal(totalPrice));
    	result.setMemberPointsIncreased(memberInfo.getBonusPoints()-oldBonusPoints);
        return result;
    }
}
