package com.cosmetica.dto;

import java.util.Date;


public class CouponDTO {
	
	private int couponId;
	private String code;
	private String description;
	private int active;
	private int discountValue;	
	private Date startDate;
	private Date endDate;
	private Date insertedAt;
	private Date updatedAt;
	private BrandDTO couponBrand;

	public CouponDTO() {
		super();
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCode() {
		return code;
	}

	public int getActive() {
		return active;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int isActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public BrandDTO getCouponBrand() {
		return couponBrand;
	}

	public void setCouponBrand(BrandDTO couponBrand) {
		this.couponBrand = couponBrand;
	}


}
