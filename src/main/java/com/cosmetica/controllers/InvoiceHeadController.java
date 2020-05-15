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

import com.cosmetica.dto.InvoiceHeadDTO;
import com.cosmetica.entities.InvoiceBody;
import com.cosmetica.entities.InvoiceHead;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IInvoiceHeadService;

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
		return invoiceHeadservice.getAll();
		 
	 }
	 
	 @GetMapping("/head/{invoiceHeadId}")		//search a invoiceHead by invoiceHeadId, takes a invoiceHeadId in parameters
	 public Optional <InvoiceHead> oneinvoiceHead(@PathVariable("invoiceHeadId")int invoiceHeadId){
		 
		 if(!invoiceHeadservice.getOneById(invoiceHeadId).isPresent())
	         throw new CosmeticaException(invoiceHeadId );
		 return invoiceHeadservice.getOneById(invoiceHeadId);
		 
	 }
	 
	 @GetMapping("/head/body/{invoiceHeadId}")	//get invoiceHead's body, takes an invoiceHeadId in parameters
	 public InvoiceBody invoiceHeadBody(@PathVariable("invoiceHeadId")int invoiceHeadId) {
		 if(!invoiceHeadservice.getOneById(invoiceHeadId).isPresent())
	         throw new CosmeticaException(invoiceHeadId );
		 InvoiceHead invoiceHead = invoiceHeadservice.getOneById(invoiceHeadId).orElseThrow(() -> new CosmeticaException(invoiceHeadId));
		 return invoiceHeadservice.getBody(invoiceHead); 
	 }
	 
	 @PutMapping("/superadmin/head/modify")		//modify a head , takes the new invoiceHead in parameters
	 public void modifyinvoicehead(@RequestBody InvoiceHeadDTO source) {
		 InvoiceHead target = new InvoiceHead();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 invoiceHeadservice.saveOrUpdate(target);
		 
	 }

	 @PostMapping("/client/head/add")			//create invoice info , takes an invoiceHead in parameters
	 public void addinvoiceHead(@RequestBody InvoiceHeadDTO invoiceHeadDto) {
		 
		 InvoiceHead invoiceHead = new InvoiceHead();
		 ModelMapper model = new ModelMapper();
		 model.map(invoiceHeadDto, invoiceHead);
		 invoiceHeadservice.saveOrUpdate(invoiceHead);
		 
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
	 
	 @DeleteMapping("/head/remove/{invoiceHeadId}")	//remove a invoiceHead , takes an invoiceHeadId in parameters
	 public void removeinvoiceHead(@PathVariable("invoiceHeadId")int invoiceHeadId) {
		 if(!invoiceHeadservice.getOneById(invoiceHeadId).isPresent())
	         throw new CosmeticaException(invoiceHeadId );
		 InvoiceHead invoiceHead = invoiceHeadservice.getOneById(invoiceHeadId).orElseThrow(() -> new CosmeticaException(invoiceHeadId));
		 invoiceHeadservice.delete(invoiceHead); 
		 
	 }
	
	
}
