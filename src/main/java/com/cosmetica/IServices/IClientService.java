package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Client;
import com.cosmetica.Entities.Review;

public interface IClientService {
	
	public List<Client> getAll();

	public Optional<Client> getOneById(int id);
	
	public Optional<Client> getOneByUsername(String username);

	public void saveOrUpdate(Client client);

	public void delete(Client client);
	
	public List<Cart> getClientCart(Client client);
	
	public boolean verifyPassword(Client client, String password);
	
	public List<Review> getClientReviews(Client client);
	
	public Double getClientAmountSpent(Client client);
	
	public Optional<Client> verifyLogin(String username, String email);
	
	public Optional<Client> getOneByEmail(String email);
	
	public Optional<Client> getOneByUsernameOrEmail(String username,String email);
	
	public List<Client> getOneByFirstnameOrLastname(String firstname,String lastname);

}
