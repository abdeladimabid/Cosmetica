package com.cosmetica.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Client;


@Repository
public interface IClientDao extends JpaRepository<Client , Integer>{

	Optional<Client> findByUsernameOrEmail(String username, String email);
	List<Client> findByEmailOrUsernameContaining(String email, String username);
	List<Client> findByFirstnameContaining(String firstname);
	List<Client> findByLastnameContaining(String lastname);
	List<Client> findByUsernameContaining(String username);
	Optional<Client> findByEmail(String email);
}
