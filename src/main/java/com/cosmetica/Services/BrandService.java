package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IBrandDao;
import com.cosmetica.Entities.Brand;
import com.cosmetica.Entities.Coupon;
import com.cosmetica.Entities.Product;
import com.cosmetica.IServices.IBrandService;

@Service
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
	
	public List<Product> getBrandProduct(Brand Brand){
		return Brand.getProducts();
	}
	
	public List<Coupon> getBrandCoupons(Brand Brand){
		return Brand.getCoupons();
	}
}
