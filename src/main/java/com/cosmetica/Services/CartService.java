package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.ICartDao;
import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Order;
import com.cosmetica.Entities.User;
import com.cosmetica.IServices.ICartService;


public class CartService implements ICartService{
	
	@Autowired
	ICartDao dao;

	@Override
	public List<Cart> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Cart> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Cart cart) {
		dao.save(cart);
	}

	@Override
	public void delete(Cart cart) {
		dao.delete(cart);
	}

	@Override
	public User getCartUser(Cart cart) {
		return cart.getCart_user();
	}
	
	@Override
	public double getTotalAmount(Cart cart) {
		double amount = 0;
		List<Order> orders = cart.getOrders();
		for (Order o : orders) {
			if(o.getOrder_product().getDiscount()==0){
			amount = amount+o.getQuantity()*o.getOrder_product().getRegular_price();}
			else {
			amount = amount+o.getQuantity()*o.getOrder_product().getRegular_price()*(o.getOrder_product().getDiscount()/100);	
			}
		}
		return amount;
	}
	
	@Override
	public List<Order> getCartOrders(Cart cart) {
		return cart.getOrders();
	}
	
}
