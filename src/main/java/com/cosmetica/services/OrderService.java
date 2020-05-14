package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IOrederDao;
import com.cosmetica.entities.Cart;
import com.cosmetica.entities.Order;
import com.cosmetica.entities.Product;
import com.cosmetica.entities.User;
import com.cosmetica.iservices.IOrderService;

@Service
public class OrderService implements IOrderService{

	@Autowired
	IOrederDao dao;

	@Override
	public List<Order> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Order> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Order order) {
		dao.save(order);
	}

	@Override
	public void delete(Order order) {
		dao.delete(order);
	}
	
	@Override
	public User getOrderUser(Order order) {
		return order.getOrderCart().getCartUser();
	}
	
	@Override
	public Product getOrderProduct(Order order) {
		return order.getOrderProduct();
	}
	
	@Override
	public Cart getOrderCart(Order order) {
		return order.getOrderCart();
	}

}
