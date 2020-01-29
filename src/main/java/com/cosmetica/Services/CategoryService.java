package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.ICategoryDao;
import com.cosmetica.Entities.Category;
import com.cosmetica.Entities.Product;
import com.cosmetica.IServices.ICategoryService;

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
	public void saveOrUpdate(Category Category) {
		dao.save(Category);
	}

	@Override
	public void delete(Category Category) {
		dao.delete(Category);
	}
	
	@Override
	public List<Product> getCategoryPruducts(Category Category) {
		return Category.getProducts();
	}
	
	@Override
	public List<Category> getCategoryChildren(Category category){
		return category.getChildren();
	}

}
