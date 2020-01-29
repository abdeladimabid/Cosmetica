package com.cosmetica.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@JsonIgnoreProperties(ignoreUnknown = true , value = {"hibernateLazyInitializer", "handler", "carts",})
public class Client extends User{

	private String adresse;
	private double amountSpent;
	
	@OneToMany(mappedBy = "userReview",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Review> userReviews;

	@OneToMany(mappedBy = "cartUser",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Cart> carts;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String username, String firstname, String lastname, String email, String password, String token,
			boolean active, Role role) {
		super(username, firstname, lastname, email, password, token, active, role);
		// TODO Auto-generated constructor stub
	}

	public Client(String username, String firstname, String lastname, String email, String password, String token,
			boolean active, Role role, String adresse) {
		super(username, firstname, lastname, email, password, token, active, role);
		this.adresse = adresse;
		this.amountSpent = 0;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(double amount_spent) {
		this.amountSpent = amount_spent;
	}

	public List<Review> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(List<Review> user_reviews) {
		this.userReviews = user_reviews;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", amount_spent=" + amountSpent + ", user_reviews=" + userReviews
				+ ", carts=" + carts + "]";
	}


	
	

}
