package com.cosmetica.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class Client extends User{

	private String adresse;
	private double amount_spent;
	
	@OneToMany(mappedBy = "user_review",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Review> user_reviews;

	@OneToMany(mappedBy = "cart_user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
		this.amount_spent = 0;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getAmount_spent() {
		return amount_spent;
	}

	public void setAmount_spent(double amount_spent) {
		this.amount_spent = amount_spent;
	}

	public List<Review> getUser_reviews() {
		return user_reviews;
	}

	public void setUser_reviews(List<Review> user_reviews) {
		this.user_reviews = user_reviews;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", amount_spent=" + amount_spent + ", user_reviews=" + user_reviews
				+ ", carts=" + carts + "]";
	}


	
	

}
