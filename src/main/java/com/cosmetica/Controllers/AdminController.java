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
import com.cosmetica.Entities.Role;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IAdminService;
import com.cosmetica.IServices.IRoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class AdminController {
	
	@Autowired
	IAdminService adminservice;
	@Autowired
	IRoleService roleserv;
	
	@GetMapping("/admins")							//get all admins
	 public List<Admin> allAdmins() {
		List<Admin> admins = adminservice.getAll();
		return admins;
		 
	 }
	 
	 @GetMapping("/admin/id/{admin_id}")			//search an admin using id, takes an Admin_Id in parameters
	 public Optional <Admin> oneAdmin(@PathVariable("admin_id")int admin_id){
		 
		 if(!adminservice.getOneById(admin_id).isPresent())
	         throw new CosmeticaException(admin_id );
		 return adminservice.getOneById(admin_id);
		 
	 }
	 
	 @GetMapping("/admin/un/{username}")			//search an admin using %username%, takes a username in parameters
	 public List <Admin> AdminByUsername(@PathVariable("username")String username){
		 
		 if(adminservice.getOneByUsername(username).isEmpty())
	         throw new CosmeticaException(username );
		 return adminservice.getOneByUsername(username);
		 
	 }

	 @PostMapping("/add/admin")						//add an admin, takes a new Admin in parameters
	 public void addAdmin(@RequestBody Admin admin) {
		 adminservice.saveOrUpdate(admin);
		 
	 }
	 
	 @PutMapping("/modify/admin")					//modify an admin, takes the new Admin in parameters
	 public void modifyAdmin(@RequestBody Admin admin) {
		 adminservice.saveOrUpdate(admin);
		 
	 }
	 
	 @DeleteMapping("/remove/admin/{admin_id}")		//remove an admin, takes an Admin_Id in parameters
	 public void removeAdmin(@PathVariable("admin_id")int admin_id) {
		 if(!adminservice.getOneById(admin_id).isPresent())
	         throw new CosmeticaException(admin_id );
		 Admin admin = adminservice.getOneById(admin_id).get();
		 adminservice.delete(admin); 
		 
	 }
	 
	 @GetMapping("/admin/email/{email}")		//search an admin using full email, takes an email in parameters
	 public Admin getOneByEmail(@PathVariable("email")String email){
		 if(!adminservice.getOneByEmail(email).isPresent())
	         throw new CosmeticaException(email);
		 Admin admin = adminservice.getOneByEmail(email).get();
		 return admin;
		 
	 }
	 
	 @GetMapping("/admin/login/{login}")		//search an admin using full email or %username%, takes a login in parameters
	 public List<Admin> getOneBylogin(@PathVariable("login")String login){
		 return adminservice.getByUsernameOrEmail(login, login);
		 
	 }
	 
	 @GetMapping("/admin/role/{id}")			//get admin role, takes an Admin_Id in parameters
	 public Role AdminRole(@PathVariable("id")int id){
		 if(!adminservice.getOneById(id).isPresent())
	         throw new CosmeticaException(id );
		 Admin admin = adminservice.getOneById(id).get();
		 return admin.getUserRole();
		 
	 }
	 
	//new method
     @PostMapping("/admin/superadmin/this/isacomplicated/link/to/add/a/superasmin")    //creates a superadmin, takes a new Admin in parameters
     public void addSuperAdmin() {
         Role role =roleserv.getOneById(1).get();
         Admin admin = new Admin("superadmin","abdel","admin","cosmetica@gmail.com","admin","",true,role);
         adminservice.saveOrUpdate(admin);

     }

//new method
     @PostMapping("/admin/modifypassword")        //modify an admins password, takes a new Admin in parameters
     public void modifypass(@RequestBody int id, String password) {
         if(!adminservice.getOneById(id).isPresent())
             throw new CosmeticaException(id);
         Admin admin = adminservice.getOneById(id).get();
         admin.setPassword(password);
         adminservice.saveOrUpdate(admin);

     }

//new method
    @PostMapping("/admin/validate")                //validate an admin, takes an Admin_id in parameters
    public void validate(@RequestBody int id) {
     if(!adminservice.getOneById(id).isPresent())
        throw new CosmeticaException(id);
     Admin admin = adminservice.getOneById(id).get();
     admin.setActive(true);
     adminservice.saveOrUpdate(admin);

    }

//new method
    @PostMapping("/admin/invalidate")                //unvalidate an admin, takes an Admin_id in parameters
    public void invalidate(@RequestBody int id) {
    if(!adminservice.getOneById(id).isPresent())
        throw new CosmeticaException(id);
    Admin admin = adminservice.getOneById(id).get();
    admin.setActive(false);
    adminservice.saveOrUpdate(admin);

    }
}
