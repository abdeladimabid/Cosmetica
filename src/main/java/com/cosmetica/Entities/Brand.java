package com.cosmetica.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="brands")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int brand_id;
	
	private String name;
	private String slogan;
	private String logo;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	
	@OneToMany(mappedBy="product_brand",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Product>products;
	
	@OneToMany(mappedBy="coupon_brand",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Coupon> coupons;

	public Brand(String name, String slogan, String logo) {
		super();
		this.name = name;
		this.slogan = slogan;
		this.logo = logo;
		this.inserted_at = new Date();
	}

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Brand [brand_id=" + brand_id + ", name=" + name + ", slogan=" + slogan + ", logo=" + logo
				+ ", inserted_at=" + inserted_at + ", updated_at=" + updated_at + ", products=" + products
				+ ", coupons=" + coupons + "]";
	}
	
	
	
	
	

}
