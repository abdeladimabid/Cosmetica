package com.cosmetica.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reviews")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "userReview","productReview"})
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="userId",nullable = false)
	private Client userReview;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="productId",nullable = false)
	private Product productReview;
	
	private int stars;
	private String title;
	private String body;
	private int status;
	@CreationTimestamp
	private Date insertedAt;
	@UpdateTimestamp
	private Date updatedAt;
	

	public Review(Client userReview, Product productReview, int stars, String title, String body) {
		super();
		this.userReview = userReview;
		this.productReview = productReview;
		this.stars = stars;
		this.title = title;
		this.body = body;
		this.status = 0;
		this.insertedAt = new Date();
	}

	public Review() {
		super();
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Client getUserReview() {
		return userReview;
	}

	public void setUserReview(Client userReview) {
		this.userReview = userReview;
	}

	public Product getProductReview() {
		return productReview;
	}

	public void setProductReview(Product productReview) {
		this.productReview = productReview;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		return "Review [reviewId=" + reviewId + ", userReview=" + userReview + ", productReview=" + productReview
				+ ", stars=" + stars + ", title=" + title + ", body=" + body + ", status=" + status + ", insertedAt="
				+ insertedAt + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
