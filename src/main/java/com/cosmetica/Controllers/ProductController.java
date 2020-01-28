package com.cosmetica.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.Entities.Image;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.Review;
import com.cosmetica.Entities.Tag;
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
	 
	 @GetMapping("/product/{product_id}")
	 public Optional <Product> oneProduct(@PathVariable("product_id")int product_id){
		 
		 if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 return productservice.getOneById(product_id);
		 
	 }

	 @PostMapping("/add/product")
	 public void addProduct(@RequestBody Product produit) {
		 productservice.saveOrUpdate(produit);
		 
	 }
	 @PutMapping("/modify/product")
	 public void modifyProduct(@RequestBody Product produit) {
		 productservice.saveOrUpdate(produit);
		 
	 }
	 
	 @DeleteMapping("/remove/product/{product_id}")
	 public void removeProduct(@PathVariable("product_id")int product_id) {
		 if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 Product product=productservice.getOneById(product_id).get();
		 productservice.delete(product); 
		 
	 }
	 @GetMapping("/product/tags/{product_id}")
	 public List<Tag> allProductTags(@PathVariable("product_id")int product_id) {
		if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 Product product=productservice.getOneById(product_id).get();
		 List<Tag> tags=productservice.getProductTags(product);
		 return tags;
				 
		 }
	 
	 @GetMapping("/product/reviews/{product_id}")
	 public List<Review> allProductRviews(@PathVariable("product_id")int product_id) {
		if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 Product product=productservice.getOneById(product_id).get();
		 List<Review> views=productservice.getProductReviews(product);
		 return views;
	 
		 }
	 
	 @GetMapping("/product/images/{product_id}")
	 public List<Image> allProductImages(@PathVariable("product_id")int product_id) {
		if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 Product product=productservice.getOneById(product_id).get();
		 List<Image> images=productservice.getProductImages(product);
		 return images;
 
		 }
	 
	 @GetMapping("/product/instock/{ref}")
	 public boolean ProductInStock(@PathVariable("ref")String ref) {
		return productservice.productInStock(ref);
	 
	 }
	 
	 
}


