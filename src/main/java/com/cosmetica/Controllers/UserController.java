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

import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.User;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class UserController {
	@Autowired
	IUserService userservice;
	
	 @GetMapping("/users")
	 public List<User > allUsers() {
		List<User> users = userservice.getAll();
		return users;
		 
	 }
	 
	 @GetMapping("/user/{user_id}")
	 public Optional <User> oneUser(@PathVariable("user_id")int user_id){
		 
		 if(!userservice.getOneById(user_id).isPresent())
	         throw new CosmeticaException(user_id );
		 return userservice.getOneById(user_id);
		 
	 }

	 @PostMapping("/add/user")
	 public void addUser(@RequestBody User produit) {
		 userservice.saveOrUpdate(produit);
		 
	 }
	 @PutMapping("/modify/user")
	 public void modifyUser(@RequestBody User user) {
		 userservice.saveOrUpdate(user);
		 
	 }
	 
	 @DeleteMapping("/remove/user/{user_id}")
	 public void removeUser(@PathVariable("user_id")int user_id) {
		 if(!userservice.getOneById(user_id).isPresent())
	         throw new CosmeticaException(user_id);
		 User user=userservice.getOneById(user_id).get();
		 userservice.delete(user); 
		 
	 }


}
