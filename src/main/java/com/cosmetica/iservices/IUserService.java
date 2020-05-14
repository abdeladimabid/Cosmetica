package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.User;

public interface IUserService {
	
	public List<User> getAll();

	public Optional<User> getOneById(int id);
	
	public List<User> getOneByUsername(String username);

	public void saveOrUpdate(User user);

	public void delete(User user);
	
	public Optional<User> verifyLogin(String username, String email);
	
	public Optional<User> getOneByEmail(String email);
	
	public Optional<User> findByUsername(String username);

	public List<User> getByUsernameOrEmail(String username,String email);
	
	public List<User> getOneByFirstnameOrLastname(String firstname,String lastname);

	public String verifyPassword(String password);

}
