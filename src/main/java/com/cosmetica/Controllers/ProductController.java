package com.cosmetica.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.Entities.Product;
import com.cosmetica.IServices.IProductService;


@RestController
@RequestMapping("COSMETICA")
public class ProductController {
	@Autowired
	IProductService productservice;
	
	 @GetMapping("/products")
	 public List<Product > allProducts() {
		List<Product> produit = productservice.getAll();
		return produit;
		 
	 }
	 

}
