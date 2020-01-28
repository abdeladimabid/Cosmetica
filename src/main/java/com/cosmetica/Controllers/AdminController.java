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

import com.cosmetica.Entities.Admin;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IAdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class AdminController {
	
	@Autowired
	IAdminService adminservice;
	
	@GetMapping("/admins")
	 public List<Admin> allAdmins() {
		List<Admin> admin = adminservice.getAll();
		return admin;
		 
	 }
	 
	 @GetMapping("/admin/{admin_id}")
	 public Optional <Admin> oneAdminById(@PathVariable("admin_id")int admin_id){
		 
		 if(!adminservice.getOneById(admin_id).isPresent())
	         throw new CosmeticaException(admin_id );
		 return adminservice.getOneById(admin_id);
		 
	 }
	 
	 @GetMapping("/admin/{username}")
	 public List <Admin> oneAdminByUsername(@PathVariable("username")String username){
		 
		 if(adminservice.getOneByUsername(username).isEmpty())
	         throw new CosmeticaException(username );
		 return adminservice.getOneByUsername(username);
		 
	 }

	 @PostMapping("/add/admin")
	 public void addAdmin(@RequestBody Admin admin) {
		 adminservice.saveOrUpdate(admin);
		 
	 }
	 @PutMapping("/modify/admin")
	 public void modifyAdmin(@RequestBody Admin admin) {
		 adminservice.saveOrUpdate(admin);
		 
	 }
	 @DeleteMapping("/remove/admin/{admin_id}")
	 public void removeAdmin(@PathVariable("admin_id")int admin_id) {
		 if(!adminservice.getOneById(admin_id).isPresent())
	         throw new CosmeticaException(admin_id );
		 Admin admin = adminservice.getOneById(admin_id).get();
		 adminservice.delete(admin); 
		 
	 }

}
