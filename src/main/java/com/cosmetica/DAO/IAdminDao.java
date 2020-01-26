package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Admin;

@Repository
public interface IAdminDao  extends JpaRepository<Admin , Integer>{
	
	List<Admin> findByFirstnameOrLastname(String firstname, String lastname);
	Optional<Admin> findByUsernameOrEmail(String username,String email);
	Optional<Admin> findByUsername(String username);
	Optional<Admin> findByEmail(String email);
	
}
