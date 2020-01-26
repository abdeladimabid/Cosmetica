package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Client;


@Repository
public interface IClientDao extends JpaRepository<Client , Integer>{

	List<Client> findByFirstnameOrLastname(String firstname, String lastname);
	Optional<Client> findByUsernameOrEmail(String username,String email);
	Optional<Client> findByUsername(String username);
	Optional<Client> findByEmail(String email);
}
