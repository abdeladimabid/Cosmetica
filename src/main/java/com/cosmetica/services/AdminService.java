package com.cosmetica.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IAdminDao;
import com.cosmetica.entities.Admin;
import com.cosmetica.iservices.IAdminService;

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
	public String verifyPassword(String password) throws NoSuchAlgorithmException {
		String salted= "21232f297a57a5a743894a0e4a801fc3"+password; //admin in MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(salted.getBytes());
		byte[] digest = md.digest();
		StringBuilder sb = new StringBuilder();
		for(byte b: digest) {
			sb.append(Integer.toHexString((b & 0xff)));
		}
		return sb.toString();
	}

	@Override
	public Optional<Admin> verifyLogin(String username, String email) {
		return dao.findByUsernameOrEmail(username, email);
	}

	@Override
	public Optional<Admin> getOneByEmail(String email) {
		return dao.findByEmail(email); 
	}

	@Override
	public List<Admin> getByUsernameOrEmail(String email, String username) {	// method to search a admin by full email or %username%
		return dao.findByEmailOrUsernameContaining(email, username);
	}

	@Override
	public List<Admin> getOneByFirstnameOrLastname(String firstname, String lastname) {
		List<Admin> first = dao.findByFirstnameContaining(firstname);
		List<Admin> last = dao.findByLastnameContaining(lastname);
		first.addAll(last);
		return first;
	}

}
