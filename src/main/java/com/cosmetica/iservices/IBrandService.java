package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Brand;
import com.cosmetica.entities.Coupon;
import com.cosmetica.entities.Product;


public interface IBrandService {
	
	public List<Brand> getAll();

	public Optional<Brand> getOneById(int id);

	public void saveOrUpdate(Brand brand);

	public void delete(Brand brand);

	public List<Product> getBrandProducts(Brand brand);
	
	public List<Coupon> getBrandCoupons(Brand brand);
	
	public List<Brand> getOneByBrandName(String username);
	

}
