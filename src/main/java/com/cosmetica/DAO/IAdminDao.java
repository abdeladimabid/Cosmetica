package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Admin;

@Repository
public interface IAdminDao  extends JpaRepository<Admin , Integer>{
	
	Optional<Admin> findByUsernameOrEmail(String firstname, String lastname);
	List<Admin> findByFirstnameOrLastnameContaining(String firstname, String lastname);
	List<Admin> findByUsernameOrEmailContaining(String username,String email);
	List<Admin> findByUsernameContaining(String username);
	Optional<Admin> findByEmail(String email);
	
}
