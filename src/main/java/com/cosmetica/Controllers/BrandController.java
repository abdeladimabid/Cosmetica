package com.cosmetica.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.Entities.Brand;
import com.cosmetica.Entities.Coupon;
import com.cosmetica.Entities.Product;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IBrandService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class BrandController {
	
	@Autowired
	IBrandService brandservice;
	
	@GetMapping("/brands")
	 public List<Brand> allBrands() {
		List<Brand> brands = brandservice.getAll();
		return brands;
		 
	 }
	 
	 @GetMapping("/brand/{brand_id}")
	 public Optional <Brand> oneBrand(@PathVariable("brand_id")int brand_id){
		 
		 if(!brandservice.getOneById(brand_id).isPresent())
	         throw new CosmeticaException(brand_id );
		 return brandservice.getOneById(brand_id);
		 
	 }
	 
	 @GetMapping("/brand/{username}")
	 public List <Brand> BrandByUsername(@PathVariable("username")String username){
		 
		 if(brandservice.getOneByBrandName(username).isEmpty())
	         throw new CosmeticaException(username );
		 return brandservice.getOneByBrandName(username);
		 
	 }

	 @PostMapping("/add/brand")
	 public void addBrand(@RequestBody Brand Brand) {
		 brandservice.saveOrUpdate(Brand);
		 
	 }
	 @PutMapping("/modify/brand")
	 public void modifyBrand(@RequestBody Brand Brand) {
		 brandservice.saveOrUpdate(Brand);
		 
	 }
	 
	 @DeleteMapping("/brand/remove/{brand_id}")
	 public void removeBrand(@PathVariable("brand_id")int brand_id) {
		 if(!brandservice.getOneById(brand_id).isPresent())
	         throw new CosmeticaException(brand_id );
		 Brand Brand = brandservice.getOneById(brand_id).get();
		 brandservice.delete(Brand); 
		 
	 }
	 
	 @GetMapping("/brand/coupons/id/{brand_id}")
	 public List<Coupon> brandCouponsById(@PathVariable("brand_id")int brand_id) {
		 if(!brandservice.getOneById(brand_id).isPresent())
	         throw new CosmeticaException(brand_id );
		 Brand Brand = brandservice.getOneById(brand_id).get();
		 return brandservice.getBrandCoupons(Brand); 
	 }
	 
	 @GetMapping("/brand/coupons/un/{username}")
	 public List<Coupon> brandCouponsByUsername(@PathVariable("username")String username) {
		 if(brandservice.getOneByBrandName(username).isEmpty())
	         throw new CosmeticaException(username );
		 List<Brand> Brand = brandservice.getOneByBrandName(username);
		 return brandservice.getBrandCoupons(Brand.get(0)); 
	 }

	 @GetMapping("/brand/products/id/{brand_id}")
	 public List<Product> brandProductsById(@PathVariable("brand_id")int brand_id) {
		 if(!brandservice.getOneById(brand_id).isPresent())
	         throw new CosmeticaException(brand_id );
		 Brand Brand = brandservice.getOneById(brand_id).get();
		 return brandservice.getBrandProducts(Brand); 
	 }
	 
	 @GetMapping("/brand/products/un/{username}")
	 public List<Product> brandProductsByUsername(@PathVariable("username")String username) {
		 if(brandservice.getOneByBrandName(username).isEmpty())
	         throw new CosmeticaException(username );
		 List<Brand> Brand = brandservice.getOneByBrandName(username);
		 return brandservice.getBrandProducts(Brand.get(0)); 
	 }

}
