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

import com.cosmetica.dto.CategoryDTO;
import com.cosmetica.entities.Category;
import com.cosmetica.entities.Product;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.ICategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class CategoryController {

	@Autowired
	ICategoryService categoryservice;
	
	@GetMapping("/category/all")
	public List<Category> allCategories(){
		return categoryservice.getAll();

	}
	
	 @GetMapping("/category/{category_id}")
	 public Optional<Category> oneCategory(@PathVariable("categoryId")int categoryId){
		 
		 if(!categoryservice.getOneById(categoryId).isPresent())
	         throw new CosmeticaException(categoryId );
		 return categoryservice.getOneById(categoryId);
		 
	 }
	@GetMapping("/category/children/{category_id}")
	public List<Category> allCategoryChlidren(@PathVariable("categoryId")int categoryId){
		
		if(!categoryservice.getOneById(categoryId).isPresent())
	         throw new CosmeticaException(categoryId );
		 Category category=categoryservice.getOneById(categoryId).orElseThrow(() -> new CosmeticaException(categoryId));
		 return categoryservice.getCategoryChildren(category);

	}
	
	 @PostMapping("/superadmin/add/cateory")
	 public void addCategory(@RequestBody CategoryDTO  source) {
		 Category target = new Category();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(source, target);
		 categoryservice.saveOrUpdate(target);
		 
	 }
	 
	 @PutMapping("/superadmin/modify/cateory")
	 public void modifyCategory(@RequestBody CategoryDTO  source) {
		 Category target = new Category();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 categoryservice.saveOrUpdate(target);
		 
	 }
	 
	 @DeleteMapping("/superadmin/remove/category/{categoryId}")
	 public void removeCategory(@PathVariable("categoryId")int categoryId) {
		 if(!categoryservice.getOneById(categoryId).isPresent())
	         throw new CosmeticaException(categoryId );
		 Category category=categoryservice.getOneById(categoryId).orElseThrow(() -> new CosmeticaException(categoryId));
		 categoryservice.delete(category); 
		 
	 }
	 
	 @GetMapping("/category/products/{categoryId}")
	 public List<Product> getCategoryPruducts(@PathVariable("categoryId")int categoryId){
		 if(!categoryservice.getOneById(categoryId).isPresent())
	         throw new CosmeticaException(categoryId );
		   Category category=categoryservice.getOneById(categoryId).orElseThrow(() -> new CosmeticaException(categoryId));
		   return categoryservice.getCategoryPruducts(category);
		 
	 }

}
