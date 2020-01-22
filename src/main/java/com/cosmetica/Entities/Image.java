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
	private int image_id;
	private String alt;
	private String path;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="product_id",nullable = false)
	private Product product_image;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(String alt, String path, Product product) {
		super();
		this.alt = alt;
		this.path = path;
		this.product_image = product;
		this.inserted_at = new Date();
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
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


	public Product getProduct_image() {
		return product_image;
	}

	public void setProduct_image(Product product_image) {
		this.product_image = product_image;
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

	@Override
	public String toString() {
		return "Image [image_id=" + image_id + ", alt=" + alt + ", path=" + path + ", product_image=" + product_image
				+ ", inserted_at=" + inserted_at + ", updated_at=" + updated_at + "]";
	}

	
	
	

}
