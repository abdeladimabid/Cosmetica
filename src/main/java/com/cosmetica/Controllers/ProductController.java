package com.cosmetica.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.Entities.Product;
import com.cosmetica.Exceptions.CosmeticaException;
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
	 
	 @GetMapping("/product/search/id/{product_id}")
	 public Optional <Product> oneProduct(@PathVariable("product_id")int product_id){
		 
		 if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 return productservice.getOneById(product_id);
		 
	 }

	 @PostMapping("/product")
	 public void addProduct(@RequestBody Product produit) {
		 productservice.saveOrUpdate(produit);
		 
	 }
	 @DeleteMapping("/remove/{product_id}")
	 public void removeProduct(@PathVariable("product_id")int product_id) {
		 if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 productservice.delete(product_id); 
		 
	 }
	 
}
