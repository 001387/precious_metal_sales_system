package com.codeing.sales.members;

public class MemberInfo {
	private String level;
	private String cardId;
	private String bonusPoints;
	private String name;
	
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

	public String getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(String bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
}
