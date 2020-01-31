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
import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Client;
import com.cosmetica.Entities.Review;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class ClientController {
	
	@Autowired
	IClientService clientservice;

	@GetMapping("/superadmin/client/all")
	 public List<Client> allClients() {
		List<Client> clients = clientservice.getAll();
		return clients;
		 
	 }
	 
	 @GetMapping("/supervisor/client/id/{client_id}")
	 public Optional <Client> oneClient(@PathVariable("client_id")int client_id){
		 
		 if(!clientservice.getOneById(client_id).isPresent())
	         throw new CosmeticaException(client_id );
		 return clientservice.getOneById(client_id);
		 
	 }

	 @GetMapping("/supervisor/client/un/{username}")
	 public List <Client> ClientsByUsername(@PathVariable("username")String username){
		
		 if(clientservice.getOneByUsername(username).isEmpty())
	         throw new CosmeticaException(username);
		 return clientservice.getOneByUsername(username);
		 
	 }

	 @PostMapping("/superadmin/add/client")
	 public void addClient(@RequestBody Client Client) {
		 clientservice.saveOrUpdate(Client);
		 
	 }
	 
	 @PutMapping("/client/modify")
	 public void modifyClient(@RequestBody Client Client) {
		 clientservice.saveOrUpdate(Client);
		 
	 }
	 
	 @DeleteMapping("/superadmin/client/remove/{client_id}")
	 public void removeClient(@PathVariable("client_id")int client_id) {
		 if(!clientservice.getOneById(client_id).isPresent())
	         throw new CosmeticaException(client_id );
		 Client client = clientservice.getOneById(client_id).get();
		 clientservice.delete(client); 
		 
	 }
	 
	 @GetMapping("/client/cart/{client_id}")
	 public List<Cart> ClientCart(@PathVariable("client_id")int client_id){
		 if(!clientservice.getOneById(client_id).isPresent())
	         throw new CosmeticaException(client_id );
		 Client client = clientservice.getOneById(client_id).get();
		 List<Cart> carts=clientservice.getClientCart(client);
		 return carts;
		 
	 }
	 
	 @GetMapping("/client/verifylogin/{log}")
	 public boolean verifyClientByUsername(@PathVariable("log")String log){
		 if(!clientservice.verifyLogin(log,log).isPresent()) return false;
		 return true;
		 
	 }
	 
	 @GetMapping("/supervisor/client/email/{email}")
	 public Optional <Client> ClientsByEmail(@PathVariable("email")String email){
		 if(!clientservice.getOneByEmail(email).isPresent())
	         throw new CosmeticaException(email);
		 return clientservice.getOneByEmail(email); 
	 }
		

	 @GetMapping("/supervisor/client/reviews/{client_id}")
		public List<Review> clientReviews(@PathVariable("client_id")int client_id){
			if(!clientservice.getOneById(client_id).isPresent())
		         throw new CosmeticaException(client_id );
			 Client client = clientservice.getOneById(client_id).get();
			 List<Review> reviews =clientservice.getClientReviews(client);
			 return reviews;
			
		}
	 @GetMapping("/client/amountspent/{client_id}")
	 public Double clientAmountSpent(@PathVariable("client_id")int client_id) {
		 if(!clientservice.getOneById(client_id).isPresent())
	         throw new CosmeticaException(client_id );
		 Client client = clientservice.getOneById(client_id).get();
		 return clientservice.getClientAmountSpent(client);
		 
	 }
	 
	 @GetMapping("/supervisor/client/name/{name}")
	 public List<Client> clientByFirstnameOrLastname(@PathVariable("name")String name){
		 return clientservice.getByFirstnameOrLastname(name, name);
		 
	 }

	//new method
	    @PostMapping("/client/validate")                //validate an a client, takes an client_id in parameters
	    public void validate(@RequestBody int id) {
	     if(!clientservice.getOneById(id).isPresent())
	        throw new CosmeticaException(id);
	     Client client = clientservice.getOneById(id).get();
	     client.setActive(true);
	     clientservice.saveOrUpdate(client);

	    }

	//new method
	    @PostMapping("/client/invalidate")                //unvalidate a client, takes an client_id in parameters
	    public void invalidateed(@RequestBody int id) {
	    if(!clientservice.getOneById(id).isPresent())
	        throw new CosmeticaException(id);
	    Client client = clientservice.getOneById(id).get();
	    client.setActive(false);
	    clientservice.saveOrUpdate(client);

	    }

	//new method
	    @PostMapping("/client/modifypassword")        //modify a client's password, takes an id_client in parameters
	    public void modifypass(@RequestBody int id, String password) {
	     if(!clientservice.getOneById(id).isPresent())
	        throw new CosmeticaException(id);
	     Client client = clientservice.getOneById(id).get();
	     client.setPassword(password);
	     clientservice.saveOrUpdate(client);

	}
		
}
