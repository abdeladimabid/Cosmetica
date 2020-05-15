package com.cosmetica.dto;

import java.util.Date;

public class UserDTO {

	private int userId;
	protected String username;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String password;
	protected String token;
	protected boolean active;
	private Date insertedAt;
	private Date updatedAt;
	protected RoleDTO userRole;
		

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


	public RoleDTO getUserRole() {
		return userRole;
	}


	public void setUserRole(RoleDTO userRole) {
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


}
