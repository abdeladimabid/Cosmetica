package com.cosmetica.Controllers;

import java.util.ArrayList;
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

import com.cosmetica.Entities.Image;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.Review;
import com.cosmetica.Entities.Tag;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.Exceptions.DuplicateKeyException;
import com.cosmetica.Exceptions.ItemDontExistException;
import com.cosmetica.IServices.ICategoryService;
import com.cosmetica.IServices.IProductService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class ProductController {
	
	@Autowired
	IProductService productservice;
	@Autowired
	ICategoryService categoryservice;
	
	 @GetMapping("/supervisor/product/all")						//get all Products
	 public List<Product > allProducts() {
		List<Product> products = productservice.getAll();
		return products;
		 
	 }
	 
	 @GetMapping("/product/all")						//get all Products where quantity > 0 and status = 1
	 public List<Product > ClientallProducts() {
		 List<Product> products = productservice.getAllClient();
		 return products;
		 
	 }
	 
	 @GetMapping("/supervisor/product/id/{product_id}")			//get one Product, id_Product is given in parameters
	 public Optional <Product> oneProduct(@PathVariable("product_id")int product_id){
		 
		 if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 return productservice.getOneById(product_id);
		 
	 }
	 
	 @GetMapping("/product/id/{product_id}")			//get one Product, id_Product is given in parameters
	 public Optional <Product> oneProductClient(@PathVariable("product_id")int product_id){
		 
		 if(!productservice.getOneById(product_id).isPresent())
			 throw new CosmeticaException(product_id );
		 Product product = productservice.getOneById(product_id).get();
		 if(product.getStatus()==1) {
		 return productservice.getOneById(product_id);
		 } else throw new ItemDontExistException(product_id);
		 
	 }
	 
	 @GetMapping("/product/name/{product_name}")			//get one Product, id_Product is given in parameters
	 public List<Product> ProductByNameClient(@PathVariable("product_name")String product_name){
		 
		 if(productservice.getByName(product_name).isEmpty())
			 throw new CosmeticaException(product_name );
			 return productservice.getByName(product_name);
		 
	 }
	 
	 @GetMapping("/saller/product/name/{product_name}")			//get one Product, id_Product is given in parameters
	 public List<Product> ProductByNameSaller(@PathVariable("product_name")String product_name){
		 
		 if(productservice.getByNameA(product_name).isEmpty())
			 throw new CosmeticaException(product_name );
		 return productservice.getByNameA(product_name);
		 
	 }

	 @PostMapping("/saller/add/product")					//add a new Product, new Product is given in parameters
	 public void addProduct(@RequestBody Product produit) {
		 if(productservice.getOneByRef(produit.getProductref()).isPresent()) {
	         throw new DuplicateKeyException(produit.getProductref());
	     } else { productservice.saveOrUpdate(produit); }
		 
	 }

	 @PutMapping("/saller/modify/product")					//modify a Product, new Product is given in parameters
	 public void modifyProduct(@RequestBody Product produit) {
		 productservice.saveOrUpdate(produit);
		 
	 }
	 
	 @DeleteMapping("/saller/remove/product/{product_id}")	//remove a Product, id_Product is given in parameters
	 public void removeProduct(@PathVariable("product_id")int product_id) {
		 if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 Product product=productservice.getOneById(product_id).get();
		 productservice.delete(product); 
		 
	 }
	 @GetMapping("/product/tags/{product_id}")		//get a Product's tags, id_Product is given in parameters
	 public List<Tag> allProductTags(@PathVariable("product_id")int product_id) {
		if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 Product product=productservice.getOneById(product_id).get();
		 List<Tag> tags=productservice.getProductTags(product);
		 return tags;
				 
		 }
	 
	 @GetMapping("/product/reviews/{product_id}")	//get a Product's reviews, id_Product is given in parameters
	 public List<Review> allProductRviews(@PathVariable("product_id")int product_id) {
		if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 Product product=productservice.getOneById(product_id).get();
		 List<Review> reviews=productservice.getProductReviews(product);
		 return reviews;
	 
		 }
	 
	 @GetMapping("/product/images/{product_id}")	//get a Product's images, id_Product is given in parameters
	 public List<Image> allProductImages(@PathVariable("product_id")int product_id) {
		if(!productservice.getOneById(product_id).isPresent())
	         throw new CosmeticaException(product_id );
		 Product product=productservice.getOneById(product_id).get();
		 List<Image> images=productservice.getProductImages(product);
		 return images;
 
		 }
	 
	 @GetMapping("/product/instock/{ref}")			//check if a Product exists in stock, Product Reference is given in parameters
	 public boolean productInStock(@PathVariable("ref")String ref) {
		return productservice.productInStock(ref);
	 
	 }

	 @GetMapping("/products/between/{p1}/{p2}")		//get Products In a Price Range, Price1 and 2 are given in parameters
	 public List<Product> productsBetween(@PathVariable double p1, @PathVariable double p2) {
		return productservice.getProductsBetween(p1, p2);
	 }
  
	 @GetMapping("/product/rating/{rate}")			//get Products with a certain rate that you give in parameters
     public List<Product> ProductsByRate(@PathVariable("rate")int rate) {
        List<Product> products = productservice.getAll();
        List<Product> listprod= new ArrayList<>();
        for(Product p : products) {
            if(Math.round(productservice.getProductStars(p))==rate) listprod.add(p);
        }
        return listprod;
     }
	 
	 @GetMapping("/product/rate/{product_id}")	//get a Product's rate, id_Product is given in parameters
     public float ProductRate(@PathVariable("product_id")int product_id) {
		 if(!productservice.getOneById(product_id).isPresent())
	        throw new CosmeticaException(product_id );
		 	Product product=productservice.getOneById(product_id).get();
            return productservice.getProductStars(product);
     }
	

	 @GetMapping("/product/featured")	//get Featured Products
	 public List<Product> featuredProducts() {
		return productservice.getFeaturedProducts();
	 
	 }

	 @GetMapping("/product/new")		//get 10 New Arrivals
	 public List<Product> newProducts() {
		return productservice.getNewArrivals();
	 
	 }
	 
	 @GetMapping("/product/top")		//get Top 10 Rated Products 
	 public List<Product > topProducts() {
		return productservice.getTopProducts();
		 
	 }
	 
	 @GetMapping("/product/hotdeals")	//get Hot Deals "top 10 deals with big discounts" 
	 public List<Product > hotDeals() {
		return productservice.getHotDeals();
		 
	 }
	 
	 @GetMapping("/product/deal")		//get Deal Of The Day "best deal with big discount"
	 public Product dealOfTheDay() {
		return productservice.getDealOfTheDay();
		 
	 }

	//new method
     @PostMapping("/product/validate")                //validate an a product, takes an product_id in parameters
        public void validate(@RequestBody int id) {
         if(!productservice.getOneById(id).isPresent())
            throw new CosmeticaException(id);
         Product product = productservice.getOneById(id).get();
         product.setStatus(1);;
         productservice.saveOrUpdate(product);

        }

     //new method
    @PostMapping("/saller/product/invalidate")                //unvalidate a product, takes an product_id in parameters
        public void invalidate(@RequestBody int id) {
        if(!productservice.getOneById(id).isPresent())
            throw new CosmeticaException(id);
        Product product = productservice.getOneById(id).get();
        product.setStatus(0);
        productservice.saveOrUpdate(product);

        }
    
    @GetMapping("/saller/product/category/{cat_id}")			//get Products of a certain category that you pass in parameters
    public List<Product> ProductsByCategory(@PathVariable("cat_id")int cat_id) {
    	if(!categoryservice.getOneById(cat_id).isPresent())
            throw new CosmeticaException(cat_id);
        return productservice.getCategoryProducts(cat_id);
    }

//new method
    @GetMapping("/product/xsell/{product_id}")    //get a Product's rate, id_Product is given in parameters
        public List<Product> ProductXsell(@PathVariable("product_id")int product_id) {
            if(!productservice.getOneById(product_id).isPresent())
                throw new CosmeticaException(product_id );
            Product product=productservice.getOneById(product_id).get();
            return productservice.productsSuggestionX(product);
        }
    
  //new method
    @GetMapping("/product/usell/{product_id}")    //get a Product's rate, id_Product is given in parameters
        public List<Product> ProductUsell(@PathVariable("product_id")int product_id) {
            if(!productservice.getOneById(product_id).isPresent())
                throw new CosmeticaException(product_id );
            Product product=productservice.getOneById(product_id).get();
            return productservice.productsSuggestionU(product);
        }
}


