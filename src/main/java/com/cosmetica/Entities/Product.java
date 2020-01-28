package com.cosmetica.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="products")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "orders"})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	private String productref;// needs to be fixed
	private String product_name;
	private String product_title;
	private String product_sub_title;
	private String description;
	private Double regular_price;
	private int discount;
	private int quantity;
	private int status;
	private int tax;
	private String hash;
	private String meta_title;
	private String meta_keywords;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="category_id",nullable = false)
	private Category product_category;
	
	@ManyToMany
	@JoinTable(name="product_tags",joinColumns=@JoinColumn(name="product_id"),inverseJoinColumns =@JoinColumn(name="tag_id"))
	private List<Tag> product_tags;

	@OneToMany(mappedBy = "product_image",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Image> images;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="brand_id",nullable = false)
	private Brand product_brand;

	@OneToMany(mappedBy = "order_product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Order> orders;
	
	
	@OneToMany(mappedBy = "product_review",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Review> product_reviews;

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String product_ref, String product_name, String product_title, String product_sub_title,
			String description, Double regular_price, int quantity, String meta_title, String meta_keywords,
			Category category, List<Tag> tags, List<Image> images, Brand brand, int tax) {
		super();
		this.productref = product_ref;
		this.product_name = product_name;
		this.product_title = product_title;
		this.product_sub_title = product_sub_title;
		this.description = description;
		this.regular_price = regular_price;
		this.quantity = quantity;
		this.meta_title = meta_title;
		this.meta_keywords = meta_keywords;
		this.product_category = category;
		this.product_tags = tags;
		this.images = images;
		this.product_brand = brand;
		this.tax = tax;
		this.inserted_at = new Date();
		this.status = 0;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	


	public String getProductref() {
		return productref;
	}

	public void setProductref(String productref) {
		this.productref = productref;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getProduct_sub_title() {
		return product_sub_title;
	}

	public void setProduct_sub_title(String product_sub_title) {
		this.product_sub_title = product_sub_title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRegular_price() {
		return regular_price;
	}

	public void setRegular_price(Double regular_price) {
		this.regular_price = regular_price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getMeta_title() {
		return meta_title;
	}

	public void setMeta_title(String meta_title) {
		this.meta_title = meta_title;
	}

	public String getMeta_keywords() {
		return meta_keywords;
	}

	public void setMeta_keywords(String meta_keywords) {
		this.meta_keywords = meta_keywords;
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

	public Category getProduct_category() {
		return product_category;
	}

	public void setProduct_category(Category product_category) {
		this.product_category = product_category;
	}

	public List<Tag> getProduct_tags() {
		return product_tags;
	}

	public void setProduct_tags(List<Tag> product_tags) {
		this.product_tags = product_tags;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Brand getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(Brand product_brand) {
		this.product_brand = product_brand;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Review> getProduct_reviews() {
		return product_reviews;
	}

	public void setProduct_reviews(List<Review> product_reviews) {
		this.product_reviews = product_reviews;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", productRef=" + productref + ", product_name=" + product_name
				+ ", product_title=" + product_title + ", product_sub_title=" + product_sub_title + ", description="
				+ description + ", regular_price=" + regular_price + ", discount=" + discount + ", quantity=" + quantity
				+ ", status=" + status + ", tax=" + tax + ", hash=" + hash + ", meta_title=" + meta_title
				+ ", meta_keywords=" + meta_keywords + ", inserted_at=" + inserted_at + ", updated_at=" + updated_at
				+ ", product_category=" + product_category + ", product_tags=" + product_tags + ", images=" + images
				+ ", product_brand=" + product_brand + ", orders=" + orders + ", product_reviews=" + product_reviews
				+ "]";
	}




}
