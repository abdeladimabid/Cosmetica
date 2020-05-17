package com.cosmetica.controllers;

import java.util.ArrayList;
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

import com.cosmetica.dto.ProductDTO;
import com.cosmetica.entities.Image;
import com.cosmetica.entities.Product;
import com.cosmetica.entities.Review;
import com.cosmetica.entities.Tag;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.exceptions.DuplicateKeyException;
import com.cosmetica.exceptions.ItemDontExistException;
import com.cosmetica.iservices.ICategoryService;
import com.cosmetica.iservices.IProductService;


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
		return productservice.getAll();
		 
	 }
	 
	 @GetMapping("/product/all")						//get all Products where quantity > 0 and status = 1
	 public List<Product > clientallProducts() {
		 return productservice.getAllClient();
	 }
	 
	 @GetMapping("/supervisor/product/id/{productId}")			//get one Product, id_Product is given in parameters
	 public Optional <Product> oneProduct(@PathVariable("productId")int productId){
		 
		 if(!productservice.getOneById(productId).isPresent())
	         throw new CosmeticaException(productId );
		 return productservice.getOneById(productId);
		 
	 }
	 
	 @GetMapping("/product/id/{productId}")			//get one Product, id_Product is given in parameters
	 public Optional <Product> oneProductClient(@PathVariable("productId")int productId){
		 
		 if(!productservice.getOneById(productId).isPresent())
			 throw new CosmeticaException(productId );
		 Product product = productservice.getOneById(productId).orElseThrow(()-> new CosmeticaException(productId));
		 if(product.getStatus()==1) {
		 return productservice.getOneById(productId);
		 } else throw new ItemDontExistException(productId);
		 
	 }
	 
	 @GetMapping("/product/name/{productName}")			//get one Product, id_Product is given in parameters
	 public List<Product> productByNameClient(@PathVariable("productName")String productName){
		 
		if(productservice.getByName(productName).isEmpty())throw new CosmeticaException(productName );
		return productservice.getByName(productName);
		 
	 }
	 
	 @GetMapping("/saller/product/name/{productName}")			//get one Product, id_Product is given in parameters
	 public List<Product> productByNameSaller(@PathVariable("productName")String productName){
		 
		 if(productservice.getByNameA(productName).isEmpty())
			 throw new CosmeticaException(productName );
		 return productservice.getByNameA(productName);
		 
	 }

	 @PostMapping("/saller/add/product")					//add a new Product, new Product is given in parameters
	 public void addProduct(@RequestBody ProductDTO source) {
		 Product target = new Product();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 if(productservice.getOneByRef(target.getProductRef()).isPresent()) {
	         throw new DuplicateKeyException(target.getProductRef());
	     } else { 
		 productservice.saveOrUpdate(target); }
		 
	 }

	 @PutMapping("/saller/modify/product")					//modify a Product, new Product is given in parameters
	 public void modifyProduct(@RequestBody ProductDTO source) {
		 Product target = new Product();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 productservice.saveOrUpdate(target);
		 
	 }
	 
	 @DeleteMapping("/saller/remove/product/{productId}")	//remove a Product, id_Product is given in parameters
	 public void removeProduct(@PathVariable("productId")int productId) {
		 if(!productservice.getOneById(productId).isPresent())
	         throw new CosmeticaException(productId );
		 Product product=productservice.getOneById(productId).orElseThrow(() -> new CosmeticaException(productId));
		 productservice.delete(product); 
		 
	 }
	 @GetMapping("/product/tags/{productId}")		//get a Product's tags, id_Product is given in parameters
	 public List<Tag> allProductTags(@PathVariable("productId")int productId) {
		if(!productservice.getOneById(productId).isPresent())
	         throw new CosmeticaException(productId );
		 Product product=productservice.getOneById(productId).orElseThrow(() -> new CosmeticaException(productId));
		 return productservice.getProductTags(product);
				 
		 }
	 
	 @GetMapping("/product/reviews/{productId}")	//get a Product's reviews, id_Product is given in parameters
	 public List<Review> allProductRviews(@PathVariable("productId")int productId) {
		if(!productservice.getOneById(productId).isPresent())
	         throw new CosmeticaException(productId );
		 Product product=productservice.getOneById(productId).orElseThrow(() -> new CosmeticaException(productId));
		 return productservice.getProductReviews(product);
	 
		 }
	 
	 @GetMapping("/product/images/{productId}")	//get a Product's images, id_Product is given in parameters
	 public List<Image> allProductImages(@PathVariable("productId")int productId) {
		if(!productservice.getOneById(productId).isPresent())
	         throw new CosmeticaException(productId );
		 Product product=productservice.getOneById(productId).orElseThrow(() -> new CosmeticaException(productId));
		 return productservice.getProductImages(product);
 
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
     public List<Product> productsByRate(@PathVariable("rate")int rate) {
        List<Product> products = productservice.getAll();
        List<Product> listprod= new ArrayList<>();
        for(Product p : products) {
            if(Math.round(productservice.getProductStars(p))==rate) listprod.add(p);
        }
        return listprod;
     }
	 
	 @GetMapping("/product/rate/{productId}")	//get a Product's rate, id_Product is given in parameters
     public float productRate(@PathVariable("productId")int productId) {
		 if(!productservice.getOneById(productId).isPresent())
	        throw new CosmeticaException(productId );
		 	Product product=productservice.getOneById(productId).orElseThrow(() -> new CosmeticaException(productId));
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
     @PostMapping("/product/validate")                //validate an a product, takes an productId in parameters
        public void validate(@RequestBody int id) {
         if(!productservice.getOneById(id).isPresent())
            throw new CosmeticaException(id);
         Product product = productservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
         product.setStatus(1);
         productservice.saveOrUpdate(product);

        }

     //new method
    @PostMapping("/saller/product/invalidate")                //unvalidate a product, takes an productId in parameters
        public void invalidate(@RequestBody int id) {
        if(!productservice.getOneById(id).isPresent())
            throw new CosmeticaException(id);
        Product product = productservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
        product.setStatus(0);
        productservice.saveOrUpdate(product);

        }
    
    @GetMapping("/saller/product/category/{catId}")			//get Products of a certain category that you pass in parameters
    public List<Product> productsByCategory(@PathVariable("catId")int catId) {
    	if(!categoryservice.getOneById(catId).isPresent())
            throw new CosmeticaException(catId);
        return productservice.getCategoryProducts(catId);
    }

//new method
    @GetMapping("/product/xsell/{productId}")    //get similar Products, id_Product is given in parameters
        public List<Product> productXsell(@PathVariable("productId")int productId) {
            if(!productservice.getOneById(productId).isPresent())
                throw new CosmeticaException(productId );
            Product product=productservice.getOneById(productId).orElseThrow(() -> new CosmeticaException(productId));
            return productservice.productsSuggestionX(product);
        }
    
  //new method
    @GetMapping("/product/usell/{productId}")    //get a better Product, id_Product is given in parameters
        public List<Product> productUsell(@PathVariable("productId")int productId) {
            if(!productservice.getOneById(productId).isPresent())
                throw new CosmeticaException(productId );
            Product product=productservice.getOneById(productId).orElseThrow(() -> new CosmeticaException(productId));
            return productservice.productsSuggestionU(product);
        }
    
    //new method
    @GetMapping("/product/csell/{productId}")    //get complementary Products, id_Product is given in parameters
    public List<Product> productsSuggestionC(@PathVariable("productId")int productId) {
    	if(!productservice.getOneById(productId).isPresent())
    		throw new CosmeticaException(productId );
    	Product product=productservice.getOneById(productId).orElseThrow(() -> new CosmeticaException(productId));
    	return productservice.productsSuggestionC(product);
    }
}


