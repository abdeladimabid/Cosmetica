package com.cosmetica.dto;

import java.util.Date;
import java.util.List;

public class BrandDTO {

	private int brandId;
	private String name;
	private String slogan;
	private String logo;
	private Date insertedAt;
	private Date updatedAt;
	private List<ProductDTO>products;
	private List<CouponDTO> coupons;


	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public List<CouponDTO> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<CouponDTO> coupons) {
		this.coupons = coupons;
	}

	
	
	
	
	

}
