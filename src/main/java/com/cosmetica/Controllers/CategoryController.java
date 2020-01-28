package com.cosmetica.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.Entities.Category;

import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.ICategoryService;

@RestController
@RequestMapping("COSMETICA")
public class CategoryController {

	@Autowired
	ICategoryService categoryservice;
	
	@GetMapping("/cateories")
	public List<Category> allCategories(){
		List<Category> category = categoryservice.getAll();
		return category;

	}
	
	@GetMapping("/cateory/children/{category_id}")
	public List<Category> allCategoryChlidren(@PathVariable("category_id")int category_id){
		
		if(!categoryservice.getOneById(category_id).isPresent())
	         throw new CosmeticaException(category_id );
		 Category category=categoryservice.getOneById(category_id).get();
		List<Category> categories = categoryservice.getCategoryChildren(category);
		return categories;

	}

}
