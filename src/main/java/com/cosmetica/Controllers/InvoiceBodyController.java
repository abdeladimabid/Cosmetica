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
import com.cosmetica.Entities.InvoiceBody;
import com.cosmetica.Entities.InvoiceHead;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IInvoiceBodyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class InvoiceBodyController {
	
	@Autowired
	IInvoiceBodyService invoicebodyservice;
	
	  /*InvoiceBody is basically the recipient group of infos : 
	  **Receiving date, Recipient first name and last name, Recipient phone and address.
	  **Since those infos doesn't change regardless the type of invoice we want
	  **We store them in a separate record, then link them to different Heads
	  **Based on the type of invoice the user needs. */
	
	
	@GetMapping("/bodys")						//get all invoiceBodys
	 public List<InvoiceBody> allinvoicebodys() {
		List<InvoiceBody> invoicebodys = invoicebodyservice.getAll();
		return invoicebodys;
		 
	 }
	 
	 @GetMapping("/body/{invoicebody_id}")		//search a invoiceBody by invoicebody_Id, takes a invoicebody_Id in parameters
	 public Optional <InvoiceBody> oneinvoicebody(@PathVariable("invoicebody_id")int invoicebody_id){
		 
		 if(!invoicebodyservice.getOneById(invoicebody_id).isPresent())
	         throw new CosmeticaException(invoicebody_id );
		 return invoicebodyservice.getOneById(invoicebody_id);
		 
	 }

	 @PostMapping("/add/invoicebody")					//add recipient info , takes an invoiceBody in parameters
	 public void addinvoicebody(@RequestBody InvoiceBody invoicebody) {
		 invoicebodyservice.saveOrUpdate(invoicebody);
		 
	 }
	 @PutMapping("/modify/invoicebody")					//modify recipient info , takes the new invoiceBody in parameters
	 public void modifyinvoicebody(@RequestBody InvoiceBody invoicebody) {
		 invoicebodyservice.saveOrUpdate(invoicebody);
		 
	 }
	 
	 @DeleteMapping("/body/remove/{invoicebody_id}")		//remove a invoiceBody , takes an invoicebody_Id in parameters
	 public void removeinvoicebody(@PathVariable("invoicebody_id")int invoicebody_id) {
		 if(!invoicebodyservice.getOneById(invoicebody_id).isPresent())
	         throw new CosmeticaException(invoicebody_id );
		 InvoiceBody invoicebody = invoicebodyservice.getOneById(invoicebody_id).get();
		 invoicebodyservice.delete(invoicebody); 
		 
	 }
	 
	 @GetMapping("/body/heads/{invoicebody_id}")	//get all invoiceHeads, takes an invoicebody_Id in parameters
	 public List<InvoiceHead> invoicebodyheads(@PathVariable("invoicebody_id")int invoicebody_id) {
		 if(!invoicebodyservice.getOneById(invoicebody_id).isPresent())
	         throw new CosmeticaException(invoicebody_id );
		 InvoiceBody invoicebody = invoicebodyservice.getOneById(invoicebody_id).get();
		 return invoicebodyservice.getBodyHeads(invoicebody); 
	 }
	 
	 @GetMapping("/body/cart/{invoicebody_id}")	//get invoiceBody Cart, takes an invoicebody_Id in parameters
	 public Cart invoiceBodyCart(@PathVariable("invoicebody_id")int invoicebody_id) {
		 if(!invoicebodyservice.getOneById(invoicebody_id).isPresent())
	         throw new CosmeticaException(invoicebody_id );
		 InvoiceBody invoicebody = invoicebodyservice.getOneById(invoicebody_id).get();
		 return invoicebodyservice.getBodyCart(invoicebody); 
	 }
	 
	 
	 
	 
	 
}
