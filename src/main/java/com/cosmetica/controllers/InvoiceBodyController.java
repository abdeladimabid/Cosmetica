package com.cosmetica.controllers;

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

import com.cosmetica.entities.Cart;
import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.InvoiceHead;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IInvoiceBodyService;

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
	
	
	@GetMapping("/superadmin/body/all")						//get all invoiceBodys
	 public List<InvoiceBody> allinvoicebodys() {
		return  invoicebodyservice.getAll();
		 
	 }
	 
	 @GetMapping("/body/{invoicebodyId}")		//search a invoiceBody by invoicebodyId, takes a invoicebodyId in parameters
	 public Optional <InvoiceBody> oneinvoicebody(@PathVariable("invoicebodyId")int invoicebodyId){
		 
		 if(!invoicebodyservice.getOneById(invoicebodyId).isPresent())
	         throw new CosmeticaException(invoicebodyId );
		 return invoicebodyservice.getOneById(invoicebodyId);
		 
	 }

	 @PostMapping("/client/body/add")					//add recipient info , takes an invoiceBody in parameters
	 public void addinvoicebody(@RequestBody InvoiceBody invoicebody) {
		 invoicebodyservice.saveOrUpdate(invoicebody);
		 
	 }
	 
	 @PutMapping("/client/body/modify")					//modify recipient info , takes the new invoiceBody in parameters
	 public void modifyinvoicebody(@RequestBody InvoiceBody invoicebody) {
		 invoicebodyservice.saveOrUpdate(invoicebody);
		 
	 }
	 
	 @DeleteMapping("/client/body/remove/{invoicebodyId}")		//remove a invoiceBody , takes an invoicebodyId in parameters
	 public void removeinvoicebody(@PathVariable("invoicebodyId")int invoicebodyId) {
		 if(!invoicebodyservice.getOneById(invoicebodyId).isPresent())
	         throw new CosmeticaException(invoicebodyId );
		 InvoiceBody invoicebody = invoicebodyservice.getOneById(invoicebodyId).orElseThrow(() -> new CosmeticaException(invoicebodyId));
		 invoicebodyservice.delete(invoicebody); 
		 
	 }
	 
	 @GetMapping("/body/heads/{invoicebodyId}")	//get all invoiceHeads, takes an invoicebodyId in parameters
	 public List<InvoiceHead> invoicebodyheads(@PathVariable("invoicebodyId")int invoicebodyId) {
		 if(!invoicebodyservice.getOneById(invoicebodyId).isPresent())
	         throw new CosmeticaException(invoicebodyId);
		 InvoiceBody invoicebody = invoicebodyservice.getOneById(invoicebodyId).orElseThrow(() -> new CosmeticaException(invoicebodyId));
		 return invoicebodyservice.getBodyHeads(invoicebody); 
	 }
	 
	 @GetMapping("/body/cart/{invoicebodyId}")	//get invoiceBody Cart, takes an invoicebodyId in parameters
	 public Cart invoiceBodyCart(@PathVariable("invoicebodyId")int invoicebodyId) {
		 if(!invoicebodyservice.getOneById(invoicebodyId).isPresent())
	         throw new CosmeticaException(invoicebodyId );
		 InvoiceBody invoicebody = invoicebodyservice.getOneById(invoicebodyId).orElseThrow(() -> new CosmeticaException(invoicebodyId));
		 return invoicebodyservice.getBodyCart(invoicebody); 
	 }
	 
	 
	 
	 
	 
}
