package com.coding.sales.members;

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
}
