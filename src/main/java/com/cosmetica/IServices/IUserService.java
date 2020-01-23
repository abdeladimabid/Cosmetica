package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.User;

public interface IUserService {
	
	public List<User> getAll();

	public Optional<User> getOneById(int id);
	
	public Optional<User> getOneByUsername(String username);
	
	public Optional<User> findByEmail(String email);
	
	public List<User> findByFirstnameAndLastname(String firstname, String lastname);

	public void saveOrUpdate(User user);

	public void delete(User user);
	
	public List<Cart> getUserCart(User user);

}
