package com.cosmetica.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Admin extends User{

	public Admin(String username, String firstname, String lastname, String email, String password, String token,
			boolean active, Role role) {
		super(username, firstname, lastname, email, password, token, active, role);
	}
	

	public Admin() {
		super();
	}


	@Override
	public String toString() {
		return "Admin []";
	}

}
