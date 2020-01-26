package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.User;

@Repository
public interface IUserDao  extends JpaRepository<User, Integer> {

	Optional<User> findByUsernameOrEmail(String firstname, String lastname);
	List<User> findByFirstnameOrLastnameLike(String firstname, String lastname);
	List<User> findByUsernameOrEmailLike(String username,String email);
	List<User> findByUsernameLike(String username);
	List<User> findByEmailLike(String email);
}
