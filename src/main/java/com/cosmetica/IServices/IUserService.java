package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.User;

public interface IUserService {
	
	public List<User> getAll();

	public Optional<User> getOneById(int id);

	public void saveOrUpdate(User user);

	public void delete(User user);
	
	public List<Cart> getUserCart(User user);

}
