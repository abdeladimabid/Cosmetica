package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.ICategoryDao;
import com.cosmetica.Entities.Category;
import com.cosmetica.IServices.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Autowired
	ICategoryDao dao;

	@Override
	public List<Category> getAll(){
		return dao.findAll();
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

}
