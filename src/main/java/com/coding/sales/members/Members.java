package com.coding.sales.members;

import java.lang.reflect.Member;
import java.util.HashMap;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Members {
	public static HashMap<String, MemberInfo> members = new HashMap<String, MemberInfo>();
	
	{
		members.put("6236609999", new MemberInfo("马丁", "普卡", "6236609999", 9860));
		members.put("6236609999", new MemberInfo("王立", "金卡", "6630009999", 48860));
		members.put("6236609999", new MemberInfo("李想", "白金卡", "8230009999", 98860));
		members.put("6236609999", new MemberInfo("张三", "钻石卡", "9230009999", 198860));
	}
	
	public static MemberInfo getMemberInfo(String cardId) {
		return members.get(cardId);
	}

	public void setMembers(MemberInfo memberInfo) {
		members.put(memberInfo.getCardId(), memberInfo);
	}
	
}
