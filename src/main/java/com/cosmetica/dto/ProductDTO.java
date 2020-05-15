package com.cosmetica.dto;

import java.util.Date;
import java.util.List;

public class ProductDTO{
	
	private int productId;
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
	private CategoryDTO productCategory;
	private List<TagDTO> productTags;
	private List<ImageDTO> images;
	private BrandDTO productBrand;
	private List<OrderDTO> orders;
	private List<ReviewDTO> productReviews;

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

	public CategoryDTO getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(CategoryDTO productCategory) {
		this.productCategory = productCategory;
	}

	public List<TagDTO> getProductTags() {
		return productTags;
	}

	public void setProductTags(List<TagDTO> productTags) {
		this.productTags = productTags;
	}

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}

	public BrandDTO getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(BrandDTO productBrand) {
		this.productBrand = productBrand;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	public List<ReviewDTO> getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(List<ReviewDTO> productReviews) {
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

	
}
