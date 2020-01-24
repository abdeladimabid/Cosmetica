package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Order;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.User;

public interface IOrderService {
	
	public List<Order> getAll();

	public Optional<Order> getOneById(int id);

	public void saveOrUpdate(Order order);

	public void delete(Order order);

	public User getOrderUser(Order Order);
	
	public Product getOrderProduct(Order Order);
	
	public Cart getOrderCart(Order Order) ;

}
