package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.InvoiceHead;
import com.cosmetica.Entities.Order;
import com.cosmetica.Entities.User;

public interface ICartService {
	
	public List<Cart> getAll();

	public Optional<Cart> getOneById(int id);

	public void saveOrUpdate(Cart cart);

	public void delete(Cart cart);

	public User getCartUser(Cart cart);
	
	public double getTotalAmount(Cart cart);
	
	public List<Order> getCartOrders(Cart cart);
	
	public List<InvoiceHead> getCartInvoiceHeads(Cart cart);
	
}
