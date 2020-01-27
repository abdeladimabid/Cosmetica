package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IAdminDao;
import com.cosmetica.Entities.Admin;
import com.cosmetica.IServices.IAdminService;

@Service
public class AdminService implements IAdminService{

	@Autowired
	IAdminDao dao;
	
	@Override
	public List<Admin> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Admin> getOneById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Admin> getOneByUsername(String username) {
		return dao.findByUsernameContaining(username); 
	}

	@Override
	public void saveOrUpdate(Admin admin) {
		dao.save(admin);
		
	}

	@Override
	public void delete(Admin admin) {
		dao.delete(admin);
		
	}

	@Override
	public boolean verifyPassword(Admin admin, String password) {
		String salt= " 21232f297a57a5a743894a0e4a801fc3"; //admin in MD5
		String hash = new BCryptPasswordEncoder().encode(password+salt);
		return admin.getPassword().matches(hash);
	}

	@Override
	public Optional<Admin> verifyLogin(String username, String email) {
		return dao.findByUsernameOrEmail(username, email);
	}

	@Override
	public List<Admin> getOneByEmail(String email) {
		return dao.findByEmailContaining(email); 
	}

	@Override
	public List<Admin> getOneByUsernameOrEmail(String username, String email) {
		return dao.findByUsernameOrEmailContaining(username, email);
	}

	@Override
	public List<Admin> getOneByFirstnameOrLastname(String firstname, String lastname) {
		return dao.findByFirstnameOrLastnameContaining(firstname, lastname);
	}

}
