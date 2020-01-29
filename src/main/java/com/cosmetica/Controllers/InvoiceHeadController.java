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

import com.cosmetica.Entities.InvoiceHead;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.Services.InvoiceHeadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class InvoiceHeadController {


	@Autowired
	InvoiceHeadService invoiceHeadservice;
	
	  /*InvoiceHead is basically the Invoice Type and dynamic infos : 
	  **Invoice Type ,Invoice reference, Invoice Date of creation.
	  **Since those infos Keep changing we store them in a head recored
	  **And depending on what type of invoice we need, 
	  **We bind the Head to a specific head.*/
	
	
	@GetMapping("/heads")						//get all invoiceHeads
	 public List<InvoiceHead> allinvoiceHeads() {
		List<InvoiceHead> invoiceHeads = invoiceHeadservice.getAll();
		return invoiceHeads;
		 
	 }
	 
	 @GetMapping("/head/{invoiceHead_id}")		//search a invoiceHead by invoiceHead_Id, takes a invoiceHead_Id in parameters
	 public Optional <InvoiceHead> oneinvoiceHead(@PathVariable("invoiceHead_id")int invoiceHead_id){
		 
		 if(!invoiceHeadservice.getOneById(invoiceHead_id).isPresent())
	         throw new CosmeticaException(invoiceHead_id );
		 return invoiceHeadservice.getOneById(invoiceHead_id);
		 
	 }

	 @PostMapping("/add/invoicehead")					//add invoice info , takes an invoiceHead in parameters
	 public void addinvoiceHead(@RequestBody InvoiceHead invoiceHead) {
		 invoiceHeadservice.saveOrUpdate(invoiceHead);
		 
	 }
	 @PutMapping("/modify/invoicehead")					//modify invoice info , takes the new invoiceHead in parameters
	 public void modifyinvoiceHead(@RequestBody InvoiceHead invoiceHead) {
		 invoiceHeadservice.saveOrUpdate(invoiceHead);
		 
	 }
	 
	 @DeleteMapping("/head/remove/{invoiceHead_id}")		//remove a invoiceHead , takes an invoiceHead_Id in parameters
	 public void removeinvoiceHead(@PathVariable("invoiceHead_id")int invoiceHead_id) {
		 if(!invoiceHeadservice.getOneById(invoiceHead_id).isPresent())
	         throw new CosmeticaException(invoiceHead_id );
		 InvoiceHead invoiceHead = invoiceHeadservice.getOneById(invoiceHead_id).get();
		 invoiceHeadservice.delete(invoiceHead); 
		 
	 }
	
	
}
