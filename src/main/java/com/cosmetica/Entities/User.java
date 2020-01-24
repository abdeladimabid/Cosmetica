package com.cosmetica.Entities;

import java.security.NoSuchAlgorithmException;

import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(unique=true)
	private String username;
	private String firstname;
	private String lastname;
	@Column(unique=true)
	private String email;
	private String password;
	private String adresse;
	private String token;
	private boolean active;
	private double amount_spent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="role_id",nullable = false)
	private Role user_role;
	
	@OneToMany(mappedBy = "user_review",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Review> user_reviews;
	
	@OneToMany(mappedBy = "cart_user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Cart> carts;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date updated_at;
	

	public User(String username, String email, String password, String token, boolean active, Role user_role) throws NoSuchAlgorithmException, InvalidKeySpecException {
		super();
		this.username = username;
		this.email = email;
		this.token = token;
		this.active = active;
		this.user_role = user_role;
		this.inserted_at = new Date();
		String salt= " 21232f297a57a5a743894a0e4a801fc3"; //admin in MD5
//		this.password = new BCryptPasswordEncoder().encode(password+salt);
	}

	
	public User(String username,String user_firstname, String user_lastname, String email, String password, String adresse,
			String token, boolean active, Role user_role) {
		super();
		this.firstname = user_firstname;
		this.lastname = user_lastname;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.token = token;
		this.active = active;
		this.user_role = user_role;
		this.inserted_at = new Date();
		this.amount_spent = 0;
		this.username = username;
	}
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
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
		return "User [user_id=" + user_id + ", username=" + username + ", user_firstname=" + firstname
				+ ", user_lastname=" + lastname + ", email=" + email + ", password=" + password + ", adresse="
				+ adresse + ", token=" + token + ", active=" + active + ", amount_spent=" + amount_spent
				+ ", user_role=" + user_role + ", user_reviews=" + user_reviews + ", carts=" + carts + ", inserted_at="
				+ inserted_at + ", updated_at=" + updated_at + "]";
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_firstname() {
		return firstname;
	}

	public void setUser_firstname(String user_firstname) {
		this.firstname = user_firstname;
	}

	public String getUser_lastname() {
		return lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.lastname = user_lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getAmount_spent() {
		return amount_spent;
	}

	public void setAmount_spent(double amount_spent) {
		this.amount_spent = amount_spent;
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

	public Role getUser_role() {
		return user_role;
	}

	public void setUser_role(Role user_role) {
		this.user_role = user_role;
	}
	
	

	
	
}
