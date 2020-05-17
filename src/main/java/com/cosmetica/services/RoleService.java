package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IRoleDao;
import com.cosmetica.entities.Role;
import com.cosmetica.entities.User;
import com.cosmetica.iservices.IRoleService;

@Service
public class RoleService implements IRoleService{

	@Autowired
	IRoleDao dao;

	@Override
	public List<Role> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Role> getOneById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Role role) {
		dao.save(role);
	}

	@Override
	public void delete(Role role) {
		dao.delete(role);
	}

	@Override
	public List<User> getUsersWithRole(Role role) {
		return role.getUsers();
	}


}
