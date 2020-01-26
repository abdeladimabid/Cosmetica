package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Category;
import com.cosmetica.Entities.Product;

public interface ICategoryService {
	
	public List<Category> getAll();

	public Optional<Category> getOneById(int id);

	public void saveOrUpdate(Category category);

	public void delete(Category category);
	
	public List<Product> getCategoryPruducts(Category Category);
	
	public List<Product> getProductsByCategory(Category category);

}
