package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Review;
import com.cosmetica.Entities.User;

public interface IUserService {
	
	public List<User> getAll();

	public Optional<User> getOneById(int id);
	
	public Optional<User> getOneByUsername(String username);

	public void saveOrUpdate(User user);

	public void delete(User user);
	
	public List<Cart> getUserCart(User user);
	
	public boolean verifyPassword(User user, String password);
	
	public List<Review> getUserReviews(User user);
	
	public Double getUserAmountSpent(User user);
	
	public Optional<User> verifyLogin(String username, String email);
	
	public Optional<User> getOneByEmail(String email);
	
	public Optional<User> getOneByUsernameOrEmail(String username,String email);
	
	public List<User> getOneByFirstnameOrLastname(String firstname,String lastname);

}
