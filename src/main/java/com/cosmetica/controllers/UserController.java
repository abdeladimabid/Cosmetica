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

import com.cosmetica.dto.UserDTO;
import com.cosmetica.entities.User;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class UserController {
	@Autowired
	IUserService userservice;
	
	 @GetMapping("/superadmin/user/all")
	 public List<User > allUsers() {
		return userservice.getAll();
		 
	 }
	 
	 @GetMapping("/user/{userId}")
	 public Optional <User> oneUser(@PathVariable("userId")int userId){
		 
		 if(!userservice.getOneById(userId).isPresent())
	         throw new CosmeticaException(userId );
		 return userservice.getOneById(userId);
		 
	 }

	 @PostMapping("/user/add")
	 public void addUser(@RequestBody UserDTO source) {
		 User target = new User();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 userservice.saveOrUpdate(target);
		 
		 
	 }
	 @PutMapping("/user/modify")
	 public void modifyUser(@RequestBody UserDTO source) {
		 User target = new User();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(source, target);
		 userservice.saveOrUpdate(target);
		 
	 }
	 
	 @DeleteMapping("/superadmin/user/remove/{userId}")
	 public void removeUser(@PathVariable("userId")int userId) {
		 if(!userservice.getOneById(userId).isPresent())
	         throw new CosmeticaException(userId);
		 User user=userservice.getOneById(userId).orElseThrow(() -> new CosmeticaException(userId));
		 userservice.delete(user); 
		 
	 }


}
