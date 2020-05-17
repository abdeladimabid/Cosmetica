package com.cosmetica.dto;

import java.util.List;

public class ClientDTO extends UserDTO{

	private String adresse;
	private double amountSpent;
	private List<ReviewDTO> userReviews;
	private List<CartDTO> carts;


	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}

	public List<ReviewDTO> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(List<ReviewDTO> userReviews) {
		this.userReviews = userReviews;
	}

	public List<CartDTO> getCarts() {
		return carts;
	}

	public void setCarts(List<CartDTO> carts) {
		this.carts = carts;
	}
	
	

}
