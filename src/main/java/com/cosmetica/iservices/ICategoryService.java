package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Category;
import com.cosmetica.entities.Product;

public interface ICategoryService {
	
	public List<Category> getAll();

	public Optional<Category> getOneById(int id);

	public void saveOrUpdate(Category category);

	public void delete(Category category);
	
	public List<Product> getCategoryPruducts(Category category);
	
	public List<Category> getCategoryChildren(Category category);

}
