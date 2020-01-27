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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "coupon_brand"})
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coupon_id;
	
	private String code;
	private String description;
	private boolean active;
	private int discount_value;	
	
	@DateTimeFormat(pattern = "dd-MMMM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date start_date;
	
	@DateTimeFormat(pattern = "dd-MMMM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date end_date;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="brand_id",nullable = false)
	private Brand coupon_brand;

	public Coupon(String code, String description, boolean active, int discount_value, Date start_date, Date end_date,
			Brand brand) {
		super();
		this.code = code;
		this.description = description;
		this.active = active;
		this.discount_value = discount_value;
		this.start_date = start_date;
		this.end_date = end_date;
		this.coupon_brand = brand;
		this.inserted_at = new Date();
	}

	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getDiscount_value() {
		return discount_value;
	}

	public void setDiscount_value(int discount_value) {
		this.discount_value = discount_value;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getInserted_at() {
		return inserted_at;
	}

	public void setInserted_at(Date inserted_at) {
		this.inserted_at = inserted_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Brand getCoupon_brand() {
		return coupon_brand;
	}

	public void setCoupon_brand(Brand coupon_brand) {
		this.coupon_brand = coupon_brand;
	}

	@Override
	public String toString() {
		return "Coupon [coupon_id=" + coupon_id + ", code=" + code + ", description=" + description + ", active="
				+ active + ", discount_value=" + discount_value + ", start_date=" + start_date + ", end_date="
				+ end_date + ", inserted_at=" + inserted_at + ", updated_at=" + updated_at + ", coupon_brand="
				+ coupon_brand + "]";
	}



}
