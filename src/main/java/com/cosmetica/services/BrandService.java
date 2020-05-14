package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IBrandDao;
import com.cosmetica.entities.Brand;
import com.cosmetica.entities.Coupon;
import com.cosmetica.entities.Product;
import com.cosmetica.iservices.IBrandService;

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
	public void saveOrUpdate(Brand brand) {
		dao.save(brand);
	}

	@Override
	public void delete(Brand brand) {
		dao.delete(brand);
	}
	
	public List<Product> getBrandProducts(Brand brand){
		return brand.getProducts();
	}
	
	public List<Coupon> getBrandCoupons(Brand brand){
		return brand.getCoupons();
	}
	
	public List<Brand> getOneByBrandName(String username){
		return dao.findByNameContaining(username);
	}
}
