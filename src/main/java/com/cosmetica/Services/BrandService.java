package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.IBrandDao;
import com.cosmetica.Entities.Brand;
import com.cosmetica.IServices.IBrandService;

public class BrandService implements IBrandService{
	
	@Autowired
	IBrandDao dao;

	@Override
	public List<Brand> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Brand> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Brand Brand) {
		dao.save(Brand);
	}

	@Override
	public void delete(Brand Brand) {
		dao.delete(Brand);
	}
	

}
