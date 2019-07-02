package com.coding.sales.product;
/**
 *@author yangshen
 * @date  2019年7月2日
 */
public class ProductInfo {
		
	private String prdName;
	private String prdNumber;
	private int unit;
	private String unitName;
	private Double price;
	private String discount;
	private String preferential;
	
	
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public String getPrdNumber() {
		return prdNumber;
	}
	public void setPrdNumber(String prdNumber) {
		this.prdNumber = prdNumber;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPreferential() {
		return preferential;
	}
	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
}
