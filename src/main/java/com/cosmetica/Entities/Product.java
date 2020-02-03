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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="products")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "orders"})
public class Product implements Comparable<Product>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(unique=true)    
	private String productRef;
	private String productName;
	private String productTitle;
	private String productSubTitle;
	private String description;
	private Double regularPrice;
	private int discount;
	private int quantity;
	private int status;
	private int featured;
	private int tax;
	private String hash;
	private String metaTitle;
	private String metaKeywords;
	private float stars;
	private Date insertedAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="categoryId",nullable = false)
	private Category productCategory;
	
	@ManyToMany
	@JoinTable(name="productTags",joinColumns=@JoinColumn(name="productId"),inverseJoinColumns =@JoinColumn(name="tagId"))
	private List<Tag> productTags;

	@OneToMany(mappedBy = "productImage",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Image> images;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="brandId",nullable = false)
	private Brand productBrand;

	@OneToMany(mappedBy = "orderProduct",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Order> orders;
	
	
	@OneToMany(mappedBy = "productReview",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Review> productReviews;

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int product_ref, String product_name, String product_title, String product_sub_title,
			String description, Double regular_price, int quantity, String meta_title, String meta_keywords,
			Category category, List<Tag> tags, List<Image> images, Brand brand, int tax) {
		super();
		this.productRef = "P00"+product_ref;
		this.productName = product_name;
		this.productTitle = product_title;
		this.productSubTitle = product_sub_title;
		this.description = description;
		this.regularPrice = regular_price;
		this.quantity = quantity;
		this.metaTitle = meta_title;
		this.metaKeywords = meta_keywords;
		this.productCategory = category;
		this.productTags = tags;
		this.images = images;
		this.productBrand = brand;
		this.tax = tax;
		this.insertedAt = new Date();
		this.status = 0;
		this.featured=0;
		this.stars=0;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductSubTitle() {
		return productSubTitle;
	}

	public void setProductSubTitle(String productSubTitle) {
		this.productSubTitle = productSubTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(Double regularPrice) {
		this.regularPrice = regularPrice;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFeatured() {
		return featured;
	}

	public void setFeatured(int featured) {
		this.featured = featured;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
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

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public List<Tag> getProductTags() {
		return productTags;
	}

	public void setProductTags(List<Tag> productTags) {
		this.productTags = productTags;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Brand getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(Brand productBrand) {
		this.productBrand = productBrand;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Review> getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(List<Review> productReviews) {
		this.productReviews = productReviews;
	}
	public String getProductRef() {
		return productRef;
	}

	public void setProductRef(String productRef) {
		this.productRef = productRef;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productRef=" + productRef + ", productName=" + productName
				+ ", productTitle=" + productTitle + ", productSubTitle=" + productSubTitle + ", description="
				+ description + ", regularPrice=" + regularPrice + ", discount=" + discount + ", quantity=" + quantity
				+ ", status=" + status + ", featured=" + featured + ", tax=" + tax + ", hash=" + hash + ", metaTitle="
				+ metaTitle + ", metaKeywords=" + metaKeywords + ", stars=" + stars + ", insertedAt=" + insertedAt
				+ ", updatedAt=" + updatedAt + ", productCategory=" + productCategory + ", productTags=" + productTags
				+ ", images=" + images + ", productBrand=" + productBrand + ", orders=" + orders + ", productReviews="
				+ productReviews + "]";
	}

	@Override
	public int compareTo(Product o) {
		Integer t = Math.round(this.getStars());
		Integer to = Math.round(o.getStars());
		return t.compareTo(to);
	}

	

}
