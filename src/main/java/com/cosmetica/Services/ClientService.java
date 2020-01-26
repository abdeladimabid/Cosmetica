package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IClientDao;
import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Client;
import com.cosmetica.Entities.Review;
import com.cosmetica.IServices.IClientService;

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

//	@Override
//	public List<Client> getOneByUsername(String username) {
//		List<String>id = dao.findByUsernameLike(username); 
//		List<Client>clients = null;
//		for (String i : id) {
//			Client c =dao.findById(Integer.parseInt(i)).get();
//			clients.add(c);
//		}
//		return clients;
//	}
	
	@Override
	public List<Client> getOneByUsername(String username) {
		return dao.findByUsernameLike(username);
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
	public boolean verifyPassword(Client client, String password) {
		String salt= " 21232f297a57a5a743894a0e4a801fc3"; //admin in MD5
		String hash = new BCryptPasswordEncoder().encode(password+salt);
		return client.getPassword().matches(hash);
	}

	@Override
	public List<Review> getClientReviews(Client client) {
		return client.getUser_reviews();
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
	public List<Client> getOneByEmail(String email) {
		return dao.findByEmailLike(email); 
	}

	@Override
	public List<Client> getOneByUsernameOrEmail(String username, String email) {
		return dao.findByUsernameOrEmailLike(username, email);
	}

	@Override
	public List<Client> getOneByFirstnameOrLastname(String firstname, String lastname) {
		return dao.findByFirstnameOrLastnameLike(firstname, lastname);
	}
	

}
