package com.cosmetica.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.Entities.Role;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IRoleService;

@RestController
@RequestMapping("COSMETICA")
public class RoleController {

	@Autowired
	IRoleService Roleservice;
	
	@GetMapping("/roles")
	 public List<Role > allRoles() {
		List<Role> Role = Roleservice.getAll();
		return Role;
		 
	 }
	 
	 @GetMapping("/role/{role_id}")
	 public Optional <Role> oneRole(@PathVariable("role_id")int role_id){
		 
		 if(!Roleservice.getOneById(role_id).isPresent())
	         throw new CosmeticaException(role_id );
		 return Roleservice.getOneById(role_id);
		 
	 }

	 @PostMapping("/role")
	 public void addRole(@RequestBody Role Role) {
		 Roleservice.saveOrUpdate(Role);
		 
	 }
	 @DeleteMapping("/role/remove/{role_id}")
	 public void removeRole(@PathVariable("role_id")int role_id) {
		 if(!Roleservice.getOneById(role_id).isPresent())
	         throw new CosmeticaException(role_id );
		 Role Role = Roleservice.getOneById(role_id).get();
		 Roleservice.delete(Role); 
		 
	 }

	
}
