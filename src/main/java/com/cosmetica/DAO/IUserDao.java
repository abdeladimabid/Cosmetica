package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.User;

@Repository
public interface IUserDao  extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	List<User> findByFirstnameOrLastnameContaining(String firstname, String lastname);
	List<User> findByUsernameOrEmailContaining(String username,String email);
	List<User> findByEmailOrUsernameContaining(String email, String username);
	Optional<User> findByUsernameOrEmail(String username,String email);
	List<User> findByFirstnameContaining(String firstname);
	List<User> findByLastnameContaining(String lastname);
	List<User> findByUsernameContaining(String username);
	Optional<User> findByEmail(String email);
}
