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

import com.cosmetica.Entities.Cart;
import com.cosmetica.Entities.Client;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class ClientController {
	
	@Autowired
	IClientService clientservice;

	@GetMapping("/clients")
	 public List<Client> allClients() {
		List<Client> Client = clientservice.getAll();
		return Client;
		 
	 }
	 
	 @GetMapping("/client/{client_id}")
	 public Optional <Client> oneClient(@PathVariable("client_id")int client_id){
		 
		 if(!clientservice.getOneById(client_id).isPresent())
	         throw new CosmeticaException(client_id );
		 return clientservice.getOneById(client_id);
		 
	 }
	 
	 @GetMapping("/client/{username}")
	 public List <Client> ClientByUsername(@PathVariable("username")String username){
		 
		 if(clientservice.getOneByUsername(username).isEmpty())
	         throw new CosmeticaException(username);
		 return clientservice.getOneByUsername(username);
		 
	 }

	 @PostMapping("/add/client")
	 public void addClient(@RequestBody Client Client) {
		 clientservice.saveOrUpdate(Client);
		 
	 }
	 @PutMapping("/modify/client")
	 public void modifyClient(@RequestBody Client Client) {
		 clientservice.saveOrUpdate(Client);
		 
	 }
	 
	 @DeleteMapping("/remove/client/{client_id}")
	 public void removeClient(@PathVariable("client_id")int client_id) {
		 if(!clientservice.getOneById(client_id).isPresent())
	         throw new CosmeticaException(client_id );
		 Client client = clientservice.getOneById(client_id).get();
		 clientservice.delete(client); 
		 
	 }
	 
	 @GetMapping("/cart/client/{client_id}")
	 public List<Cart> ClientCart(@PathVariable("client_id")int client_id){
		 if(!clientservice.getOneById(client_id).isPresent())
	         throw new CosmeticaException(client_id );
		 Client client = clientservice.getOneById(client_id).get();
		 List<Cart> carts=clientservice.getClientCart(client);
		 return carts;
		 
	 }

}
