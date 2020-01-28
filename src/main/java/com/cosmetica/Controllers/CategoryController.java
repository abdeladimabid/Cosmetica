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

import com.cosmetica.Entities.Category;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.Tag;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.ICategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class CategoryController {

	@Autowired
	ICategoryService categoryservice;
	
	@GetMapping("/categories")
	public List<Category> allCategories(){
		List<Category> categories = categoryservice.getAll();
		return categories;

	}
	
	 @GetMapping("/category/{category_id}")
	 public Optional<Category> oneCategory(@PathVariable("category_id")int category_id){
		 
		 if(!categoryservice.getOneById(category_id).isPresent())
	         throw new CosmeticaException(category_id );
		 return categoryservice.getOneById(category_id);
		 
	 }
	@GetMapping("/category/children/{category_id}")
	public List<Category> allCategoryChlidren(@PathVariable("category_id")int category_id){
		
		if(!categoryservice.getOneById(category_id).isPresent())
	         throw new CosmeticaException(category_id );
		 Category category=categoryservice.getOneById(category_id).get();
		List<Category> categories = categoryservice.getCategoryChildren(category);
		return categories;

	}
	
	 @PostMapping("/add/cateory")
	 public void addCategory(@RequestBody Category  category) {
		 categoryservice.saveOrUpdate(category);
		 
	 }
	 @PutMapping("/modify/cateory")
	 public void modifyCategory(@RequestBody Category  category) {
		 categoryservice.saveOrUpdate(category);
		 
	 }
	 
	 @DeleteMapping("/remove/category/{category_id}")
	 public void removeCategory(@PathVariable("category_id")int category_id) {
		 if(!categoryservice.getOneById(category_id).isPresent())
	         throw new CosmeticaException(category_id );
		 Category category=categoryservice.getOneById(category_id).get();
		 categoryservice.delete(category); 
		 
	 }
	 
	 @GetMapping("/category/products/{category_id}")
	 public List<Product> getCategoryPruducts(@PathVariable("category_id")int category_id){
		 if(!categoryservice.getOneById(category_id).isPresent())
	         throw new CosmeticaException(category_id );
		   Category category=categoryservice.getOneById(category_id).get();
		   List<Product> products=categoryservice.getCategoryPruducts(category);
		   return products;
		 
	 }

}
