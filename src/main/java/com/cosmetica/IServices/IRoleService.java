package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Role;
import com.cosmetica.Entities.User;

public interface IRoleService {
	
	public List<Role> getAll();

	public Optional<Role> getOneById(int id);

	public void saveOrUpdate(Role role);

	public void delete(Role role);

	public List<User> getUsersWithRole(Role role); 
	
}
