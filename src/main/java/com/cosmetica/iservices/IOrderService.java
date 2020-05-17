package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Cart;
import com.cosmetica.entities.Order;
import com.cosmetica.entities.Product;
import com.cosmetica.entities.User;

public interface IOrderService {
	
	public List<Order> getAll();

	public Optional<Order> getOneById(int id);

	public void saveOrUpdate(Order order);

	public void delete(Order order);

	public User getOrderUser(Order order);
	
	public Product getOrderProduct(Order order);
	
	public Cart getOrderCart(Order order) ;

}
