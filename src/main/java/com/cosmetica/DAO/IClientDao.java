package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Client;


@Repository
public interface IClientDao extends JpaRepository<Client , Integer>{

	Optional<Client> findByUsernameOrEmail(String firstname, String lastname);
	List<Client> findByFirstnameOrLastnameContaining(String firstname, String lastname);
	List<Client> findByUsernameOrEmailContaining(String username,String email);	
	List<Client> findByUsernameContaining(String username);
	Optional<Client> findByEmail(String email);
}
