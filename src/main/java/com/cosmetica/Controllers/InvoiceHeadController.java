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

import com.cosmetica.Entities.InvoiceBody;
import com.cosmetica.Entities.InvoiceHead;
import com.cosmetica.Entities.InvoiceType;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IInvoiceHeadService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class InvoiceHeadController {


	@Autowired
	IInvoiceHeadService invoiceHeadservice;
	
	  /*InvoiceHead is basically the Invoice Type and dynamic infos : 
	  **Invoice Type ,Invoice reference, Invoice Date of creation.
	  **Since those infos Keep changing we store them in a head recored
	  **And depending on what type of invoice we need, 
	  **We bind the Head to a specific head.*/
	
	
	@GetMapping("/superadmin/head/all")			//get all invoiceHeads
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
	 
	 @GetMapping("/head/body/{invoiceHead_id}")	//get invoiceHead's body, takes an invoiceHead_Id in parameters
	 public InvoiceBody invoiceHeadBody(@PathVariable("invoiceHead_id")int invoiceHead_id) {
		 if(!invoiceHeadservice.getOneById(invoiceHead_id).isPresent())
	         throw new CosmeticaException(invoiceHead_id );
		 InvoiceHead invoiceHead = invoiceHeadservice.getOneById(invoiceHead_id).get();
		 return invoiceHeadservice.getBody(invoiceHead); 
	 }
	 
	 @PutMapping("/superadmin/head/modify")		//modify a head , takes the new invoiceHead in parameters
	 public void modifyinvoicehead(@RequestBody InvoiceHead invoicehead) {
		 invoiceHeadservice.saveOrUpdate(invoicehead);
		 
	 }

	 @PostMapping("/client/head/add")			//create invoice info , takes an invoiceHead in parameters
	 public void addinvoiceHead(@RequestBody InvoiceHead invoiceHead) {
		 String type = invoiceHead.getType().getLabel();
		 if(type.equals("facture")) {
			 int refLast = invoiceHeadservice.getLastFac().getRef();
			 invoiceHead.setRef(refLast+1);
		 } else
		 if(type.equals("devis")) {
			 int refLast = invoiceHeadservice.getLastDev().getRef();
			 invoiceHead.setRef(refLast+1);
		 }else
			 if(type.equals("bon")) {
				 int refLast = invoiceHeadservice.getLastBon().getRef();
				 invoiceHead.setRef(refLast+1);
		 }else {
				 invoiceHead.setRef(1);
		 }
		 
		 invoiceHeadservice.saveOrUpdate(invoiceHead);
		 
	 }
	 
	 @DeleteMapping("/head/remove/{invoiceHead_id}")	//remove a invoiceHead , takes an invoiceHead_Id in parameters
	 public void removeinvoiceHead(@PathVariable("invoiceHead_id")int invoiceHead_id) {
		 if(!invoiceHeadservice.getOneById(invoiceHead_id).isPresent())
	         throw new CosmeticaException(invoiceHead_id );
		 InvoiceHead invoiceHead = invoiceHeadservice.getOneById(invoiceHead_id).get();
		 invoiceHeadservice.delete(invoiceHead); 
		 
	 }
	
	
}
