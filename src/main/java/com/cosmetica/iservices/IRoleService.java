package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Role;
import com.cosmetica.entities.User;

public interface IRoleService {
	
	public List<Role> getAll();

	public Optional<Role> getOneById(int id);

	public void saveOrUpdate(Role role);

	public void delete(Role role);

	public List<User> getUsersWithRole(Role role); 
	
}
