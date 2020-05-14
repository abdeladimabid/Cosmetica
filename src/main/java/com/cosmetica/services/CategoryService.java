package com.cosmetica.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.ICategoryDao;
import com.cosmetica.entities.Category;
import com.cosmetica.entities.Product;
import com.cosmetica.iservices.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	ICategoryDao dao;

	@Override
	public List<Category> getAll(){
		return dao.findByParentIsNull();
	}

	@Override
	public Optional<Category> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Category category) {
		dao.save(category);
	}

	@Override
	public void delete(Category category) {
		dao.delete(category);
	}
	
	@Override
	public List<Product> getCategoryPruducts(Category category) {
		List<Product> products = new ArrayList<>();
		if (!category.getChildren().isEmpty()) {
			List<Category> categories = category.getChildren();
			for(Category c : categories) {
				products.addAll(c.getProducts());
			}
			
			return products;
		}
		
		return category.getProducts();
	}
	
	@Override
	public List<Category> getCategoryChildren(Category category){
		return category.getChildren();
	}

}
