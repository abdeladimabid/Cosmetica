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

import com.cosmetica.dto.AdminDTO;
import com.cosmetica.entities.Admin;
import com.cosmetica.entities.Role;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IAdminService;
import com.cosmetica.iservices.IRoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class AdminController {
	
	@Autowired
	IAdminService adminservice;
	@Autowired
	IRoleService roleserv;
	
	@GetMapping("/superadmin/admin/all")							//get all admins
	 public List<Admin> allAdmins() {
		return adminservice.getAll();
	 }
	 
	 @GetMapping("/superadmin/admin/id/{admin_id}")			//search an admin using id, takes an Admin_Id in parameters
	 public Optional <Admin> oneAdmin(@PathVariable("admin_id")int id){
		 
		 if(!adminservice.getOneById(id).isPresent())
	         throw new CosmeticaException(id );
		 return adminservice.getOneById(id);
		 
	 }
	 
	 @GetMapping("/superadmin/admin/un/{username}")			//search an admin using %username%, takes a username in parameters
	 public List <Admin> adminByUsername(@PathVariable("username")String username){
		 
		 if(adminservice.getOneByUsername(username).isEmpty())
	         throw new CosmeticaException(username );
		 return adminservice.getOneByUsername(username);
		 
	 }

	 @PostMapping("/superadmin/add/admin")						//add an admin, takes a new Admin in parameters
	 public void addAdmin(@RequestBody AdminDTO adminDto) {
		 Admin admin = new Admin();
		 ModelMapper model = new ModelMapper();
		 model.map(adminDto, admin);
		 adminservice.saveOrUpdate(admin);
		 
	 }
	 
	 @PutMapping("/superadmin/modify/admin")					//modify an admin, takes the new Admin in parameters
	 public void modifyAdmin(@RequestBody AdminDTO adminDto) {
		 Admin admin = new Admin();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(adminDto, admin);
		 adminservice.saveOrUpdate(admin);
		 
	 }
	 
	 @DeleteMapping("/superadmin/remove/admin/{admin_id}")		//remove an admin, takes an Admin_Id in parameters
	 public void removeAdmin(@PathVariable("admin_id")int id) {
		 if(!adminservice.getOneById(id).isPresent())
	         throw new CosmeticaException(id );
		 Admin admin = adminservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
		 adminservice.delete(admin); 
		 
	 }
	 
	 @GetMapping("/superadmin/admin/email/{email}")		//search an admin using full email, takes an email in parameters
	 public Admin getOneByEmail(@PathVariable("email")String email){
		 if(!adminservice.getOneByEmail(email).isPresent())
	         throw new CosmeticaException(email);
		 return adminservice.getOneByEmail(email).orElseThrow(() -> new CosmeticaException(email));
		 
	 }
	 
	 @GetMapping("/superadmin/admin/login/{login}")		//search an admin using full email or %username%, takes a login in parameters
	 public List<Admin> getOneBylogin(@PathVariable("login")String login){
		 return adminservice.getByUsernameOrEmail(login, login);
		 
	 }
	 
	 @GetMapping("/superadmin/admin/role/{id}")			//get admin role, takes an Admin_Id in parameters
	 public Role adminRole(@PathVariable("id")int id){
		 if(!adminservice.getOneById(id).isPresent())
	         throw new CosmeticaException(id );
		 Admin admin = adminservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
		 return admin.getUserRole();
		 
	 }
	 
//	//new method
//     @PostMapping("/admin/superadmin/this/isacomplicated/link/to/add/a/superasmin")    //creates a superadmin, takes a new Admin in parameters
//     public void addSuperAdmin() {
//         Role role =roleserv.getOneById(1).get();
//         Admin admin = new Admin("superadmin","abdel","admin","cosmetica@gmail.com","admin","",true,role);
//         adminservice.saveOrUpdate(admin);
//     }

//new method
     @PostMapping("/superadmin/admin/modifypassword")        //modify an admins password, takes a new Admin in parameters
     public void modifypass(@RequestBody int id, String password) {
         if(!adminservice.getOneById(id).isPresent())
             throw new CosmeticaException(id);
         Admin admin = adminservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
         admin.setPassword(password);
         adminservice.saveOrUpdate(admin);

     }

//new method
    @PostMapping("/superadmin/admin/validate")                //validate an admin, takes an Admin_id in parameters
    public void validate(@RequestBody int id) {
     if(!adminservice.getOneById(id).isPresent())
        throw new CosmeticaException(id);
     Admin admin = adminservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
     admin.setActive(true);
     adminservice.saveOrUpdate(admin);
    }

//new method
    @PostMapping("/superadmin/admin/invalidate")                //unvalidate an admin, takes an Admin_id in parameters
    public void invalidate(@RequestBody int id) {
    if(!adminservice.getOneById(id).isPresent())
        throw new CosmeticaException(id);
    Admin admin = adminservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
    admin.setActive(false);
    adminservice.saveOrUpdate(admin);

    }
}
