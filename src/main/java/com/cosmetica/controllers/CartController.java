package com.cosmetica.controllers;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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

import com.cosmetica.dto.CartDTO;
import com.cosmetica.entities.Cart;
import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.Order;
import com.cosmetica.entities.User;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.ICartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")

public class CartController {

	@Autowired
	ICartService cartservice;
	
	 @GetMapping("/superadmin/cart/all")
	 public List<Cart > allCarts() {
		return cartservice.getAll();
		 
	 }
	 
	 @GetMapping("/cart/{cart_id}")
	 public Optional <Cart> oneCart(@PathVariable("cartId")int cartId){
		 
		 if(!cartservice.getOneById(cartId).isPresent())
	         throw new CosmeticaException(cartId );
		 return cartservice.getOneById(cartId);
		 
	 }

	 @PostMapping("/client/add/cart")
	 public void addCart(@RequestBody CartDTO source) {
		 Cart target = new Cart();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 cartservice.saveOrUpdate(target);
	 }
	 
	 @PutMapping("/client/modify/cart")
	 public void modifyCart(@RequestBody CartDTO source) {
		 Cart target = new Cart();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(source, target);
		 cartservice.saveOrUpdate(target);
		 
	 }
	 
	 @DeleteMapping("/client/remove/cart/{cartId}")
	 public void removeCart(@PathVariable("cartId")int cartId) {
		 if(!cartservice.getOneById(cartId).isPresent())
	         throw new CosmeticaException(cartId );
		 Cart cart=cartservice.getOneById(cartId).orElseThrow(() -> new CosmeticaException(cartId));
		 cartservice.delete(cart); 
		 
	 }

	 @GetMapping("/cart/user/{cartId}")
	 public User cartUser(@PathVariable("cartId")int cartId){
		 if(!cartservice.getOneById(cartId).isPresent())
	         throw new CosmeticaException(cartId );
		 Cart cart=cartservice.getOneById(cartId).orElseThrow(() -> new CosmeticaException(cartId));
		 return cartservice.getCartUser(cart);
		 
	 }
	 
	 @GetMapping("/cart/orders/{cartId}")
	 public List<Order> cartOrders(@PathVariable("cartId")int cartId){
		 if(!cartservice.getOneById(cartId).isPresent())
	         throw new CosmeticaException(cartId );
		Cart cart=cartservice.getOneById(cartId).orElseThrow(() -> new CosmeticaException(cartId));
		return cartservice.getCartOrders(cart);
		 
		 
	 }
	 @GetMapping("/cart/invoiceBody/{cartId}")
	  public InvoiceBody cartInvoiceHeads(@PathVariable("cartId")int cartId) {
		 if(!cartservice.getOneById(cartId).isPresent())
	         throw new CosmeticaException(cartId );
		   Cart cart=cartservice.getOneById(cartId).orElseThrow(() -> new CosmeticaException(cartId));
		 return cartservice.getCartInvoiceHeads(cart);
		 
	 }
	 
	 @GetMapping("/cart/anoumnt/{cartId}")
	 public double totalAmount(@PathVariable("cartId")int cartId) {
		 if(!cartservice.getOneById(cartId).isPresent())
	         throw new CosmeticaException(cartId );
		   Cart cart=cartservice.getOneById(cartId).orElseThrow(() -> new CosmeticaException(cartId));
		 return cartservice.getTotalAmount(cart);
		 
		 
	 }

     @PostMapping("/supervisor/cart/validate")
    public void validatee(@RequestBody int cartId) {
    if(!cartservice.getOneById(cartId).isPresent())
        throw new CosmeticaException(cartId );
       Cart cart=cartservice.getOneById(cartId).orElseThrow(() -> new CosmeticaException(cartId));
       cart.setStatus(1);
     cartservice.saveOrUpdate(cart);

    }


     @PostMapping("/supervisor/cart/invalidate")
    public void invalidate(@RequestBody int cartId) {
    if(!cartservice.getOneById(cartId).isPresent())
        throw new CosmeticaException(cartId );
    Cart cart=cartservice.getOneById(cartId).orElseThrow(() -> new CosmeticaException(cartId));
    cart.setStatus(0);
    cartservice.saveOrUpdate(cart);

    }
	 
}
