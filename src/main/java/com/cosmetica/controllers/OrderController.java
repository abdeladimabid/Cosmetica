package com.cosmetica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.entities.Cart;
import com.cosmetica.entities.Order;
import com.cosmetica.entities.Product;
import com.cosmetica.entities.User;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IOrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class OrderController {
	@Autowired
	IOrderService orderservice;
	
	 @GetMapping("/order/all")							//get all orders
	 public List<Order > allOrders() {
		return orderservice.getAll();
		 
	 }
	 
	 @GetMapping("/order/{orderId}")					//get order by id, takes an orderId in parameters
	 public Optional <Order> oneOrder(@PathVariable("orderId")int orderId){
		 
		 if(!orderservice.getOneById(orderId).isPresent())
	         throw new CosmeticaException(orderId );
		 return orderservice.getOneById(orderId);
		 
	 }

	 @PostMapping("/client/order/add")					//add an order, takes an order in parameters
	 public void addOrder(@RequestBody Order order) {
		 orderservice.saveOrUpdate(order);
		 
	 }
	 @PutMapping("/client/order/modify")				//modify an order, takes an order in parameters
	 public void modifyOrder(@RequestBody Order order) {
		 orderservice.saveOrUpdate(order);
		 
	 }
	 
	 @DeleteMapping("/client/order/remove/{orderId}")	//remove an order, takes an order in parameters
	 public void removeOrder(@PathVariable("orderId")int orderId) {
		 if(!orderservice.getOneById(orderId).isPresent())
	         throw new CosmeticaException(orderId );
		 Order order=orderservice.getOneById(orderId).orElseThrow(() -> new CosmeticaException(orderId));
		 orderservice.delete(order); 
		 
	 }
	
	 @GetMapping("/order/user/{orderId}")				//get order's user, takes an id_order in parameters
	 public User orderUser(@PathVariable("orderId")int orderId) {
		 if(!orderservice.getOneById(orderId).isPresent())
			 throw new CosmeticaException(orderId );
		 Order order=orderservice.getOneById(orderId).orElseThrow(() -> new CosmeticaException(orderId));
		 return orderservice.getOrderUser(order);
	        	 
	 }

	 @GetMapping("/order/product/{orderId}")			//get an orders product, takes an id_order in parameters
	 public Product orderProduct(@PathVariable("orderId")int orderId) {
		 if(!orderservice.getOneById(orderId).isPresent())
			 throw new CosmeticaException(orderId );
		 Order order=orderservice.getOneById(orderId).orElseThrow(() -> new CosmeticaException(orderId));
		 return orderservice.getOrderProduct(order);
			
		}
	 
	 @GetMapping("/order/cart/{orderId}")				//get an orders cart, takes an id_order in parameters
	 public Cart getOrderCart(@PathVariable("orderId")int orderId) {
		 if(!orderservice.getOneById(orderId).isPresent())
			 throw new CosmeticaException(orderId );
		 Order order=orderservice.getOneById(orderId).orElseThrow(() -> new CosmeticaException(orderId));
		 return orderservice.getOrderCart(order);
			
		}

}
