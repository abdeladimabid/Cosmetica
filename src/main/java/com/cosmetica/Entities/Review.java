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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reviews")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "user_review","product_review"})
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int review_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="user_id",nullable = false)
	private Client user_review;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="product_id",nullable = false)
	private Product product_review;
	
	private int stars;
	private String title;
	private String body;
	private int status;

	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	

	public Review(Client user_review, Product product_review, int stars, String title, String body) {
		super();
		this.user_review = user_review;
		this.product_review = product_review;
		this.stars = stars;
		this.title = title;
		this.body = body;
		this.status = 0;
		this.inserted_at = new Date();
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public Client getUser_review() {
		return user_review;
	}

	public void setUser_review(Client user_review) {
		this.user_review = user_review;
	}

	public Product getProduct_review() {
		return product_review;
	}

	public void setProduct_review(Product product_review) {
		this.product_review = product_review;
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
		return "Review [review_id=" + review_id + ", user_review=" + user_review + ", product_review=" + product_review
				+ ", stars=" + stars + ", title=" + title + ", body=" + body + ", status=" + status + ", inserted_at="
				+ inserted_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
	

}
