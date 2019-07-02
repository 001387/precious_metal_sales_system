package com.coding.sales.product;

import java.math.BigDecimal;

/**
 * 
 *@author yangshen
 * @date  2019年7月2日
 */
public class Product {
		
	private String prdName;
	private String productId;
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
		return productId;
	}
	public void setPrdNumber(String prdNumber) {
		this.productId = prdNumber;
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
	public Product(String prdName, String prdNumber, int unit, Double price, String discount,String preferential) {
		this.prdName = prdName;
		this.productId = prdNumber;
		this.unit = unit;
		this.price = price;
		this.discount = discount;
		this.preferential = preferential;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
}
