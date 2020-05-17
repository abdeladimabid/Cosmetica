package com.cosmetica.dto;

import java.util.Date;

public class ImageDTO {
	
	private int imageId;
	private String alt;
	private String path;
	private Date insertedAt;
	private Date updatedAt;
	private ProductDTO productImage;
	

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public ProductDTO getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductDTO productImage) {
		this.productImage = productImage;
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

	

}
