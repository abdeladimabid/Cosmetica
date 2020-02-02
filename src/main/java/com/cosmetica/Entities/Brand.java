package com.cosmetica.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="brands")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "products"})
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int brandId;
	
	@Column(unique=true)
	private String name;
	private String slogan;
	private String logo;
	private Date insertedAt;
	private Date updatedAt;
	
	@OneToMany(mappedBy="productBrand",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Product>products;
	
	@OneToMany(mappedBy="couponBrand",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Coupon> coupons;

	public Brand(String name, String slogan, String logo) {
		super();
		this.name = name;
		this.slogan = slogan;
		this.logo = logo;
		this.insertedAt = new Date(); 
	}

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brand_id) {
		this.brandId = brand_id;
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

	public void setInsertedAt(Date inserted_at) {
		this.insertedAt = inserted_at;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updated_at) {
		this.updatedAt = updated_at;
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
		return "Brand [brand_id=" + brandId + ", name=" + name + ", slogan=" + slogan + ", logo=" + logo
				+ ", inserted_at=" + insertedAt + ", updated_at=" + updatedAt + ", products=" + products
				+ ", coupons=" + coupons + "]";
	}
	
	
	
	
	

}
