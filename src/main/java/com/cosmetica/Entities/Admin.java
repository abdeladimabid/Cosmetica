package com.cosmetica.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Admin extends User{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="role_id",nullable = false)
	protected Role user_role;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String firstname, String lastname, String email, String password, String token,
			boolean active, Role role) {
		super(username, firstname, lastname, email, password, token, active, role);
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String firstname, String lastname, String email, String password, String token,
			boolean active, Role role, Role user_role) {
		super(username, firstname, lastname, email, password, token, active, role);
		this.user_role = user_role;
	}

	public Role getUser_role() {
		return user_role;
	}

	public void setUser_role(Role user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "Admin [user_role=" + user_role + "]";
	}

	

	
	

}
