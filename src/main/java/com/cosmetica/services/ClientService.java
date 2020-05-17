package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IClientDao;
import com.cosmetica.entities.Cart;
import com.cosmetica.entities.Client;
import com.cosmetica.entities.Review;
import com.cosmetica.iservices.IClientService;

@Service
public class ClientService implements IClientService{

	@Autowired
	IClientDao dao;
	
	@Override
	public List<Client> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Client> getOneById(int id) {
		return dao.findById(id);
	}
	
	@Override
	public List<Client> getOneByUsername(String username) {
		return dao.findByUsernameContaining(username);
	}

	@Override
	public void saveOrUpdate(Client client) {
		dao.save(client);
		
	}

	@Override
	public void delete(Client client) {
		dao.delete(client);
		
	}

	@Override
	public List<Cart> getClientCart(Client client) {
		return client.getCarts();
	}

	@Override
	public String verifyPassword(String password) {
		String salt= "21232f297a57a5a743894a0e4a801fc3"; //admin in MD5
		return new BCryptPasswordEncoder().encode(password+salt);
	}

	@Override
	public List<Review> getClientReviews(Client client) {
		return client.getUserReviews();
	}

	@Override
	public Double getClientAmountSpent(Client client) {
		List<Cart> carts = client.getCarts();
		double amount=0;
		CartService cs = new CartService();
		for (Cart c : carts) {
			amount=amount+cs.getTotalAmount(c);
		}
		return amount; // this one need to be tested
	}

	@Override
	public Optional<Client> verifyLogin(String username, String email) {
		return dao.findByUsernameOrEmail(username, email);
	}
	
	@Override
	public List <Client> getByEmailOrUsername(String email, String username) { // method to search a client by full email or %username%
		return dao.findByEmailOrUsernameContaining(email, username);
	}

	@Override
	public Optional<Client> getOneByEmail(String email) {
		return dao.findByEmail(email); 
	}

	
	@Override
	public List<Client> getByFirstnameOrLastname(String firstname, String lastname) {
		List<Client> first = dao.findByFirstnameContaining(firstname);
		List<Client> last = dao.findByLastnameContaining(lastname);
		first.addAll(last);
		return first;
		
	}
	

}
