package com.cosmetica.Controllers;

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

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Order;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.User;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.ICartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")

public class CartController {

	@Autowired
	ICartService cartservice;
	
	 @GetMapping("/carts")
	 public List<Cart > allCarts() {
		List<Cart> produit = cartservice.getAll();
		return produit;
		 
	 }
	 
	 @GetMapping("/cart/{cart_id}")
	 public Optional <Cart> oneProduct(@PathVariable("cart_id")int cart_id){
		 
		 if(!cartservice.getOneById(cart_id).isPresent())
	         throw new CosmeticaException(cart_id );
		 return cartservice.getOneById(cart_id);
		 
	 }

	 @PostMapping("/add/cart")
	 public void addCart(@RequestBody Cart cart) {
		 cartservice.saveOrUpdate(cart);
		 
	 }
	 @PutMapping("/modify/cart")
	 public void modifyCart(@RequestBody Cart cart) {
		 cartservice.saveOrUpdate(cart);
		 
	 }
	 
	 @DeleteMapping("/remove/cart/{cart_id}")
	 public void removeCart(@PathVariable("cart_id")int cart_id) {
		 if(!cartservice.getOneById(cart_id).isPresent())
	         throw new CosmeticaException(cart_id );
		 Cart cart=cartservice.getOneById(cart_id).get();
		 cartservice.delete(cart); 
		 
	 }

	 @GetMapping("/cart/user/{cart_id}")
	 public User getCartUser(@PathVariable("cart_id")int cart_id){
		 if(!cartservice.getOneById(cart_id).isPresent())
	         throw new CosmeticaException(cart_id );
		 Cart cart=cartservice.getOneById(cart_id).get();
		 return cartservice.getCartUser(cart);
		 
	 }
	 
	 @GetMapping("/cart/orders/{cart_id}")
	 public List<Order> CartOrders(@PathVariable("cart_id")int cart_id){
		 if(!cartservice.getOneById(cart_id).isPresent())
	         throw new CosmeticaException(cart_id );
		Cart cart=cartservice.getOneById(cart_id).get();
		List<Order> orders=cartservice.getCartOrders(cart);
		return orders;
		 
		 
	 }
	 
}
