package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.IUserDao;
import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.User;
import com.cosmetica.IServices.IUserService;

public class UserService implements IUserService{

	@Autowired
	IUserDao dao;
	
	@Override
	public List<User> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<User> getOneById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(User user) {
		dao.save(user);
		
	}

	@Override
	public void delete(User user) {
		dao.delete(user);
		
	}

	@Override
	public List<Cart> getUserCart(User user) {
		return user.getCarts();
	}
	
	
	
	

}
