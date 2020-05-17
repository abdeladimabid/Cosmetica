package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Cart;
import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.Order;
import com.cosmetica.entities.User;

public interface ICartService {
	
	public List<Cart> getAll();

	public Optional<Cart> getOneById(int id);

	public void saveOrUpdate(Cart cart);

	public void delete(Cart cart);

	public User getCartUser(Cart cart);
	
	public double getTotalAmount(Cart cart);
	
	public List<Order> getCartOrders(Cart cart);
	
	public InvoiceBody getCartInvoiceHeads(Cart cart);
	
}
