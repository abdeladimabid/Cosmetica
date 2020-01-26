package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.User;

@Repository
public interface IUserDao  extends JpaRepository<User, Integer> {

	List<User> findByFirstnameOrLastname(String firstname, String lastname);
	Optional<User> findByUsernameOrEmail(String username,String email);
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
}
