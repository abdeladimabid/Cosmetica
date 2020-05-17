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

import com.cosmetica.dto.ClientDTO;
import com.cosmetica.entities.Cart;
import com.cosmetica.entities.Client;
import com.cosmetica.entities.Review;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class ClientController {
	
	@Autowired
	IClientService clientservice;

	@GetMapping("/supervisor/client/all")
	 public List<Client> allClients() {
		return clientservice.getAll();
		 
	 }
	 
	 @GetMapping("/user/client/id/{clientId}")
	 public Optional <Client> oneClient(@PathVariable("clientId")int clientId){
		 
		 if(!clientservice.getOneById(clientId).isPresent())
	         throw new CosmeticaException(clientId );
		 return clientservice.getOneById(clientId);
		 
	 }

	 @GetMapping("/user/client/un/{username}")
	 public List <Client> clientsByUsername(@PathVariable("username")String username){
		
		 if(clientservice.getOneByUsername(username).isEmpty())
	         throw new CosmeticaException(username);
		 return clientservice.getOneByUsername(username);
		 
	 }

	 @PostMapping("/signup/client/add")
	 public void addClient(@RequestBody ClientDTO source) {
		 Client target = new Client();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 clientservice.saveOrUpdate(target);
	 }
	 
	 @PutMapping("/client/modify")
	 public void modifyClient(@RequestBody ClientDTO source) {
		 Client target = new Client();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(source, target);
		 clientservice.saveOrUpdate(target);
		 
	 }
	 
	 @DeleteMapping("/superadmin/client/remove/{clientId}")
	 public void removeClient(@PathVariable("clientId")int clientId) {
		 if(!clientservice.getOneById(clientId).isPresent())
	         throw new CosmeticaException(clientId );
		 Client client = clientservice.getOneById(clientId).orElseThrow(() -> new CosmeticaException(clientId));
		 clientservice.delete(client); 
		 
	 }
	 
	 @GetMapping("/client/cart/{clientId}")
	 public List<Cart> clientCart(@PathVariable("clientId")int clientId){
		 if(!clientservice.getOneById(clientId).isPresent())
	         throw new CosmeticaException(clientId );
		 Client client = clientservice.getOneById(clientId).orElseThrow(() -> new CosmeticaException(clientId));
		 return clientservice.getClientCart(client);
		 
	 }
	 
	 @GetMapping("/client/verifylogin/{log}")
	 public boolean verifyClientByUsername(@PathVariable("log")String log){
		 if(!clientservice.verifyLogin(log,log).isPresent()) return false;
		 return true;
	 }
	 
	 @GetMapping("/supervisor/client/email/{email}")
	 public Optional <Client> clientsByEmail(@PathVariable("email")String email){
		 if(!clientservice.getOneByEmail(email).isPresent())
	         throw new CosmeticaException(email);
		 return clientservice.getOneByEmail(email); 
	 }
		

	 @GetMapping("/supervisor/client/reviews/{clientId}")
		public List<Review> clientReviews(@PathVariable("clientId")int clientId){
			if(!clientservice.getOneById(clientId).isPresent())
		         throw new CosmeticaException(clientId );
			 Client client = clientservice.getOneById(clientId).orElseThrow(() -> new CosmeticaException(clientId));
			 return clientservice.getClientReviews(client);
			
		}
	 @GetMapping("/client/amountspent/{clientId}")
	 public Double clientAmountSpent(@PathVariable("clientId")int clientId) {
		 if(!clientservice.getOneById(clientId).isPresent())
	         throw new CosmeticaException(clientId );
		 Client client = clientservice.getOneById(clientId).orElseThrow(() -> new CosmeticaException(clientId));
		 return clientservice.getClientAmountSpent(client);
		 
	 }
	 
	 @GetMapping("/supervisor/client/name/{name}")
	 public List<Client> clientByFirstnameOrLastname(@PathVariable("name")String name){
		 return clientservice.getByFirstnameOrLastname(name, name);
		 
	 }
	//new method
	    @PostMapping("/client/validate")                //validate an a client though email link, takes an clientId in parameters
	    public void validate(@RequestBody int id) {
	     if(!clientservice.getOneById(id).isPresent())
	        throw new CosmeticaException(id);
	     Client client = clientservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
	     client.setActive(true);
	     clientservice.saveOrUpdate(client);

	    }

	//new method
	    @PostMapping("/supervisor/client/invalidate")                //unvalidate a client, takes an clientId in parameters
	    public void invalidateed(@RequestBody int id) {
	    if(!clientservice.getOneById(id).isPresent())
	        throw new CosmeticaException(id);
	    Client client = clientservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
	    client.setActive(false);
	    clientservice.saveOrUpdate(client);

	    }

	//new method
	    @PostMapping("/client/modifypassword")        //modify a client's password, takes an id_client in parameters
	    public void modifypass(@RequestBody int id, String password) {
	     if(!clientservice.getOneById(id).isPresent())
	        throw new CosmeticaException(id);
	     Client client = clientservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
	     client.setPassword(password);
	     clientservice.saveOrUpdate(client);

	}
		
}
