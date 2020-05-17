package com.cosmetica.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="coupons")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "couponBrand"})
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int couponId;
	
	private String code;
	private String description;
	private int active;
	private int discountValue;	
	private Date startDate;
	private Date endDate;
	@CreationTimestamp
	private Date insertedAt;
	@UpdateTimestamp
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="brandId",nullable = false)
	private Brand couponBrand;

	public Coupon(String code, String description, int discountValue, Date startDate, Date endDate,
			Brand brand) {
		super();
		this.code = code;
		this.description = description;
		this.active = 0;
		this.discountValue = discountValue;
		this.startDate = startDate;
		this.endDate = endDate;
		this.couponBrand = brand;
		this.insertedAt = new Date();
	}

	public Coupon() {
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

	public Brand getCouponBrand() {
		return couponBrand;
	}

	public void setCouponBrand(Brand couponBrand) {
		this.couponBrand = couponBrand;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", code=" + code + ", description=" + description + ", active=" + active
				+ ", discountValue=" + discountValue + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", insertedAt=" + insertedAt + ", updatedAt=" + updatedAt + ", couponBrand=" + couponBrand + "]";
	}




}
