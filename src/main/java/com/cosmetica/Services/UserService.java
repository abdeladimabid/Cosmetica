package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IUserDao;
import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.User;
import com.cosmetica.IServices.IUserService;

@Service
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
	public Optional<User> getOneByUsername(String username) {
		return dao.findByUsername(username);
	}
	
	@Override
	public Optional<User> findByEmail(String email) {
		return dao.findByUsername(email);
	}
	
	@Override
	public List<User> findByFirstnameAndLastname(String firstname, String lastname){
		return dao.findByFirstnameAndLastname(firstname, lastname);
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
