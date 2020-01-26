package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Admin;

@Repository
public interface IAdminDao  extends JpaRepository<Admin , Integer>{
	
	List<Admin> findByFirstnameOrLastnameLike(String firstname, String lastname);
	List<Admin> findByUsernameOrEmailLike(String username,String email);
	List<Admin> findByUsernameLike(String username);
	List<Admin> findByEmailLike(String email);
	
}
