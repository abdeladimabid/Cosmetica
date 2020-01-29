package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Admin;

public interface IAdminService {
	

	public List<Admin> getAll();

	public Optional<Admin> getOneById(int id);
	
	public List<Admin> getOneByUsername(String username);

	public void saveOrUpdate(Admin admin);

	public void delete(Admin admin);
	
	public boolean verifyPassword(int admin, String password);
	
	public Optional<Admin> verifyLogin(String username, String email);
	
	public Optional<Admin> getOneByEmail(String email);
	
	public List<Admin> getOneByUsernameOrEmail(String username,String email);
	
	public List<Admin> getOneByFirstnameOrLastname(String firstname,String lastname);
}