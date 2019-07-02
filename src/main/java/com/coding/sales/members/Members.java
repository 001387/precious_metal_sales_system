package com.coding.sales.members;

import java.util.HashMap;

import com.coding.constant.ProductItemConstant;


public class Members {
	public static HashMap<String, MemberInfo> members = new HashMap<String, MemberInfo>();
	
	static{
		members.put("6236609999", new MemberInfo("马丁", "普卡", "6236609999", 9860));
		members.put("6630009999", new MemberInfo("王立", "金卡", "6630009999", 48860));
		members.put("8230009999", new MemberInfo("李想", "白金卡", "8230009999", 98860));
		members.put("9230009999", new MemberInfo("张三", "钻石卡", "9230009999", 198860));
	}
	
	
	public static HashMap<String, Double> memberCardLevel = new HashMap<String, Double>();
	static {
		memberCardLevel.put(ProductItemConstant.MemberLevel.COMMON_CARD, 1.0);
		memberCardLevel.put(ProductItemConstant.MemberLevel.GOLD_CARD, 1.5);
		memberCardLevel.put(ProductItemConstant.MemberLevel.PLATINUM_CARD, 1.8);
		memberCardLevel.put(ProductItemConstant.MemberLevel.DIANMONDS_CARD, 2.0);
	}
	
	
	public static MemberInfo getMemberInfo(String cardId) {
		return members.get(cardId);
	}

	public void setMembers(MemberInfo memberInfo) {
		members.put(memberInfo.getCardId(), memberInfo);
	}
	
}
