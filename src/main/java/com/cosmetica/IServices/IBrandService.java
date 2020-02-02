package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Brand;
import com.cosmetica.Entities.Coupon;
import com.cosmetica.Entities.Product;


public interface IBrandService {
	
	public List<Brand> getAll();

	public Optional<Brand> getOneById(int id);

	public void saveOrUpdate(Brand brand);

	public void delete(Brand brand);

	public List<Product> getBrandProducts(Brand Brand);
	
	public List<Coupon> getBrandCoupons(Brand Brand);
	
	public List<Brand> getOneByBrandName(String username);
	

}
