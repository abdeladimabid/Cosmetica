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

import com.cosmetica.entities.InvoiceType;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IInvoiceTypeService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class InvoiceTypeController {

	@Autowired
	IInvoiceTypeService invoiceTypeservice;
	
	
	@GetMapping("/superadmin/type/all")						//get all InvoiceTypes
	 public List<InvoiceType> allInvoiceTypes() {
		return invoiceTypeservice.getAll();
		 
	 }
	 
	 @GetMapping("/superadmin/type/{InvoiceTypeId}")		//search a InvoiceType by InvoiceTypeId, takes a InvoiceTypeId in parameters
	 public Optional <InvoiceType> oneInvoiceType(@PathVariable("InvoiceTypeId")int invoiceTypeId){
		 
		 if(!invoiceTypeservice.getOneById(invoiceTypeId).isPresent())
	         throw new CosmeticaException(invoiceTypeId );
		 return invoiceTypeservice.getOneById(invoiceTypeId);
		 
	 }

	 @PostMapping("/superadmin/type/add")					//add recipient info , takes an InvoiceType in parameters
	 public void addInvoiceType(@RequestBody InvoiceType invoiceType) {
		 invoiceTypeservice.saveOrUpdate(invoiceType);
		 
	 }
	 
	 @PutMapping("/superadmin/type/modify")					//modify recipient info , takes the new InvoiceType in parameters
	 public void modifyInvoiceType(@RequestBody InvoiceType invoiceType) {
		 invoiceTypeservice.saveOrUpdate(invoiceType);
		 
	 }
	 
	 @DeleteMapping("/superadmin/type/remove/{InvoiceTypeId}")		//remove a InvoiceType , takes an InvoiceTypeId in parameters
	 public void removeInvoiceType(@PathVariable("InvoiceTypeId")int invoiceTypeId) {
		 if(!invoiceTypeservice.getOneById(invoiceTypeId).isPresent())
	         throw new CosmeticaException(invoiceTypeId );
		 InvoiceType invoiceType = invoiceTypeservice.getOneById(invoiceTypeId).orElseThrow(() -> new CosmeticaException(invoiceTypeId));
		 invoiceTypeservice.delete(invoiceType); 
		 
	 }
	
}
