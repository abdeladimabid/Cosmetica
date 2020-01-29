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

@Entity
@Table(name="images")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageId;
	private String alt;
	private String path;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="productId",nullable = false)
	private Product productImage;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date insertedAt;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updatedAt;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(String alt, String path, Product product) {
		super();
		this.alt = alt;
		this.path = path;
		this.productImage = product;
		this.insertedAt = new Date();
	}

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

	public Product getProductImage() {
		return productImage;
	}

	public void setProductImage(Product productImage) {
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

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", alt=" + alt + ", path=" + path + ", productImage=" + productImage
				+ ", insertedAt=" + insertedAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	

}
