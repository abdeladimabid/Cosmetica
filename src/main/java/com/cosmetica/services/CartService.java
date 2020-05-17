package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.ICartDao;
import com.cosmetica.entities.Cart;
import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.Order;
import com.cosmetica.entities.User;
import com.cosmetica.iservices.ICartService;

@Service
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
		return cart.getCartUser();
	}
	
	@Override
	public double getTotalAmount(Cart cart) {
		double amount = 0;
		List<Order> orders = cart.getOrders();
		for (Order o : orders) {
			//if order does not have a discount 
			if(o.getOrderProduct().getDiscount()==0){
			amount = amount+o.getQuantity()*o.getOrderProduct().getRegularPrice();}
			else {//if order does have a discount
			amount = amount+o.getQuantity()*o.getOrderProduct().getRegularPrice()*((double)o.getOrderProduct().getDiscount()/100);	
			}
		}
		return amount;
	}
	
	@Override
	public List<Order> getCartOrders(Cart cart) {
		return cart.getOrders();
	}
	
	@Override
	public InvoiceBody getCartInvoiceHeads(Cart cart) {
		return cart.getCartBody();
	}
	
}
