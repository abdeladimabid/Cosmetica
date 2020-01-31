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

import com.cosmetica.Entities.InvoiceType;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IInvoiceTypeService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class InvoiceTypeController {

	@Autowired
	IInvoiceTypeService InvoiceTypeservice;
	
	
	@GetMapping("/superadmin/type/all")						//get all InvoiceTypes
	 public List<InvoiceType> allInvoiceTypes() {
		List<InvoiceType> InvoiceTypes = InvoiceTypeservice.getAll();
		return InvoiceTypes;
		 
	 }
	 
	 @GetMapping("/superadmin/type/{InvoiceType_id}")		//search a InvoiceType by InvoiceType_Id, takes a InvoiceType_Id in parameters
	 public Optional <InvoiceType> oneInvoiceType(@PathVariable("InvoiceType_id")int InvoiceType_id){
		 
		 if(!InvoiceTypeservice.getOneById(InvoiceType_id).isPresent())
	         throw new CosmeticaException(InvoiceType_id );
		 return InvoiceTypeservice.getOneById(InvoiceType_id);
		 
	 }

	 @PostMapping("/superadmin/type/add")					//add recipient info , takes an InvoiceType in parameters
	 public void addInvoiceType(@RequestBody InvoiceType InvoiceType) {
		 InvoiceTypeservice.saveOrUpdate(InvoiceType);
		 
	 }
	 
	 @PutMapping("/superadmin/type/modify")					//modify recipient info , takes the new InvoiceType in parameters
	 public void modifyInvoiceType(@RequestBody InvoiceType InvoiceType) {
		 InvoiceTypeservice.saveOrUpdate(InvoiceType);
		 
	 }
	 
	 @DeleteMapping("/superadmin/type/remove/{InvoiceType_id}")		//remove a InvoiceType , takes an InvoiceType_Id in parameters
	 public void removeInvoiceType(@PathVariable("InvoiceType_id")int InvoiceType_id) {
		 if(!InvoiceTypeservice.getOneById(InvoiceType_id).isPresent())
	         throw new CosmeticaException(InvoiceType_id );
		 InvoiceType InvoiceType = InvoiceTypeservice.getOneById(InvoiceType_id).get();
		 InvoiceTypeservice.delete(InvoiceType); 
		 
	 }
	
}
