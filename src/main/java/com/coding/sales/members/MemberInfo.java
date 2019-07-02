package com.coding.sales.members;

import com.coding.constant.ProductItemConstant;
import com.sun.org.apache.regexp.internal.REUtil;

public class MemberInfo {
	private String name;
	private String level;
	private String cardId;
	private int bonusPoints;
	
	public MemberInfo(String name, String level, String cardId, int bonusPoints) {
		this.name = name;
		this.level = level;
		this.cardId = cardId;
		this.bonusPoints = bonusPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public int getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public void addBonusProints(Double points) {
		this.bonusPoints +=  points.intValue();
		if (bonusPoints < 10000) {
			return;
		}
		if (bonusPoints < 50000) {
			setLevel(ProductItemConstant.MemberLevel.GOLD_CARD);
			return;
		}
		if (bonusPoints < 100000) {
			setLevel(ProductItemConstant.MemberLevel.PLATINUM_CARD);
			return;
		}
		setLevel(ProductItemConstant.MemberLevel.DIANMONDS_CARD);
	}
}
