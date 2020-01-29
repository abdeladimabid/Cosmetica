package com.cosmetica.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern = "dd-MMMM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd-MMMM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date insertedAt;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="brandId",nullable = false)
	private Brand couponBrand;

	public Coupon(String code, String description, int active, int discount_value, Date start_date, Date end_date,
			Brand brand) {
		super();
		this.code = code;
		this.description = description;
		this.active = active;
		this.discountValue = discount_value;
		this.startDate = start_date;
		this.endDate = end_date;
		this.couponBrand = brand;
		this.insertedAt = new Date();
	}

	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int coupon_id) {
		this.couponId = coupon_id;
	}

	public String getCode() {
		return code;
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
