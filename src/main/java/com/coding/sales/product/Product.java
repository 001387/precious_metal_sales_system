package com.coding.sales.product;

import com.coding.constant.CommonConstant;

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
	
	
	public Double fullSub(int amount) {
		Double totalPrice = price*amount;
		if (CommonConstant.FullSubRule.FULL_3_SUB_1.equals(preferential) && amount>3) {
			totalPrice = totalPrice - price;
		}else if (CommonConstant.FullSubRule.FULL_2000_SUB_30.equals(preferential)) {
			if (totalPrice>1000 &&totalPrice<2000) {
				totalPrice = totalPrice - 10;
			}else if (totalPrice>=20000) {
				totalPrice = totalPrice - 30;
			}
		}else if (CommonConstant.FullSubRule.FULL_3000_SUB_350.equals(preferential)) {
			if (totalPrice>1000 &&totalPrice<2000) {
				totalPrice = totalPrice - 10;
			}else if (totalPrice>=2000 & totalPrice<3000) {
				totalPrice = totalPrice - 30;
			}else if (totalPrice>=3000) {
				totalPrice = totalPrice - 350;
			}
		}
		return totalPrice;
	}
	
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
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
		this.preferential = preferential;
		if (CommonConstant.ProdcutDiscount.PRODUCT_DISCOUNT_ALLOW_9.equals(discount)) {
			this.discount = "9折券";
		}else if (CommonConstant.ProdcutDiscount.PRODUCT_DISCOUNT_ALLOW_95.equals(discount)) {
			this.discount = "95折券";
		}else {
			this.discount = discount;
		}
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
