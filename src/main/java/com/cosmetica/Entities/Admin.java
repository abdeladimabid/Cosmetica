package com.cosmetica.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Admin extends User{

	public Admin(String username, String firstname, String lastname, String email, String password, String token,
			boolean active, Role role) {
		super(username, firstname, lastname, email, password, token, active, role);
		// TODO Auto-generated constructor stub
	}
	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Admin []";
	}

}
