package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Client;


@Repository
public interface IClientDao extends JpaRepository<Client , Integer>{

	List<Client> findByFirstnameOrLastnameLike(String firstname, String lastname);
	List<Client> findByUsernameOrEmailLike(String username,String email);
	List<Client> findByUsernameLike(String username);
	List<Client> findByEmailLike(String email);
}
