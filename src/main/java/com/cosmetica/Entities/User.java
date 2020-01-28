package com.cosmetica.Entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Inheritance
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="role_id",nullable = false)
	protected Role user_role;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	protected Date inserted_at;
	
	@DateTimeFormat(pattern = "E, dd-MMMM-yyyy, HH:mm:ss")
	@Temporal(TemporalType.DATE)
	protected Date updated_at;
	

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
		this.user_role = role;
		this.inserted_at = new Date();
		String salt= "21232f297a57a5a743894a0e4a801fc3"; //admin in MD5
		this.password = new BCryptPasswordEncoder().encode(password+salt);
	}

	public Role getUser_role() {
		return user_role;
	}

	public void setUser_role(Role user_role) {
		this.user_role = user_role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", password=" + password + ", token=" + token + ", active=" + active
				+ ", user_role=" + user_role + ", inserted_at=" + inserted_at + ", updated_at=" + updated_at + "]";
	}
	
	

	
	
}
