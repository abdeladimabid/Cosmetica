package com.cosmetica.dto;

import java.util.Date;

public class ReviewDTO {

	private int reviewId;
	private ClientDTO userReview;
	private ProductDTO productReview;
	private int stars;
	private String title;
	private String body;
	private int status;
	private Date insertedAt;
	private Date updatedAt;
	

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public ClientDTO getUserReview() {
		return userReview;
	}

	public void setUserReview(ClientDTO userReview) {
		this.userReview = userReview;
	}

	public ProductDTO getProductReview() {
		return productReview;
	}

	public void setProductReview(ProductDTO productReview) {
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

}
