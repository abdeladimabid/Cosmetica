package com.cosmetica.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IUserDao;
import com.cosmetica.entities.User;
import com.cosmetica.iservices.IUserService;

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
	public List<User> getOneByUsername(String username) { 
		return dao.findByUsernameContaining(username); 
		}
	  
	@Override 
	public Optional<User> getOneByEmail(String email) { 
		return dao.findByEmail(email); 
		}
	
	public Optional<User> findByUsername(String username){
		return dao.findByUsername(username);
	}
	
	@Override
	public List<User> getByUsernameOrEmail(String email,String username){
		return dao.findByEmailOrUsernameContaining(email, username);
	}
	  
	@Override 
	public List<User> getOneByFirstnameOrLastname(String firstname,String lastname){ 
		List<User> first = dao.findByFirstnameContaining(firstname);
		List<User> last = dao.findByLastnameContaining(lastname);
		first.addAll(last);
		return first;
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
	public Optional<User> verifyLogin(String username, String email) {
		return dao.findByUsernameOrEmail(username, email);
	}

	@Override
	public String verifyPassword(String password) {
		String salt= "21232f297a57a5a743894a0e4a801fc3"; //admin in MD5
		return new BCryptPasswordEncoder().encode(password+salt);
	}

}
