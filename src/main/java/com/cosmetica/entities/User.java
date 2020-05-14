package com.cosmetica.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Inheritance
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique=true)
	protected String username;
	protected String firstname;
	protected String lastname;
	@Email
	@Column(unique=true)
	protected String email;
	protected String password;
	protected String token;
	protected boolean active;
	@CreationTimestamp
	private Date insertedAt;
	@UpdateTimestamp
	private Date updatedAt;

	@ManyToOne
	@JoinColumn (name="roleId",nullable = false)
	protected Role userRole;
	

	public User(String username, String firstname, String lastname, String email, String password, String token,
			boolean active, Role role) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.token = token;
		this.active = active;
		this.userRole = role;
		this.insertedAt = new Date();
		String salt= "21232f297a57a5a743894a0e4a801fc3"; //admin in MD5
		this.password = new BCryptPasswordEncoder().encode(password+salt);
	}
	

	public User() {
		super();
	}
	

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	public Role getUserRole() {
		return userRole;
	}


	public void setUserRole(Role userRole) {
		this.userRole = userRole;
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
		return "User [userId=" + userId + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", password=" + password + ", token=" + token + ", active=" + active
				+ ", userRole=" + userRole + ", insertedAt=" + insertedAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
