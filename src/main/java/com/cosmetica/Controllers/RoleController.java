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

import com.cosmetica.Entities.Role;
import com.cosmetica.Entities.User;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IRoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class RoleController {

	@Autowired
	IRoleService Roleservice;
	
	@GetMapping("/roles")
	 public List<Role > allRoles() {
		List<Role> roles = Roleservice.getAll();
		return roles;
		 
	 }
	 
	 @GetMapping("/role/{role_id}")
	 public Optional <Role> oneRole(@PathVariable("role_id")int role_id){
		 
		 if(!Roleservice.getOneById(role_id).isPresent())
	         throw new CosmeticaException(role_id );
		 return Roleservice.getOneById(role_id);
		 
	 }

	 @PostMapping("/add/role")
	 public void addRole(@RequestBody Role Role) {
		 Roleservice.saveOrUpdate(Role);
		 
	 }
	 @PutMapping("/modify/role")
	 public void modifyRole(@RequestBody Role Role) {
		 Roleservice.saveOrUpdate(Role);
		 
	 }
	 @DeleteMapping("/remove/role/{role_id}")
	 public void removeRole(@PathVariable("role_id")int role_id) {
		 if(!Roleservice.getOneById(role_id).isPresent())
	         throw new CosmeticaException(role_id );
		 Role Role = Roleservice.getOneById(role_id).get();
		 Roleservice.delete(Role); 
		 
	 }
	 
	 @GetMapping("/roles/{role_id}")// all users that have this role
	 public List<User> allClientsWithRole(@PathVariable("role_id")int role_id) {
		 if(!Roleservice.getOneById(role_id).isPresent())throw new CosmeticaException(role_id);
		 Role role = Roleservice.getOneById(role_id).get();
		List<User> user = Roleservice.getUsersWithRole(role);
		return user;
		 
	 }

	
}
