package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Client;


@Repository
public interface IClientDao extends JpaRepository<Client , Integer>{

	Optional<Client> findByUsernameOrEmail(String firstname, String lastname);
	List<Client> findByFirstnameOrLastnameLike(String firstname, String lastname);
	List<Client> findByUsernameOrEmailLike(String username,String email);
	
//	@Query("SELECT u.user_id FROM User u WHERE u.username LIKE CONCAT('%',:username,'%')")
//	List<String> findByUsernameLike(@Param("username") String username);
//	
	List<Client> findByUsernameLike(String username);
	List<Client> findByEmailLike(String email);
}
