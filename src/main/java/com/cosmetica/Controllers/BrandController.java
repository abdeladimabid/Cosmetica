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
	
	@GetMapping("/supervisor/brand/all")							//get all brands
	 public List<Brand> allBrands() {
		List<Brand> brands = brandservice.getAll();
		return brands;
		 
	 }
	
	@GetMapping("/brand/all")							//get all brands
	public List<Brand> ClientAllBrands() {
		List<Brand> brands = brandservice.getAllBrands();
		return brands;
		
	}
	 
	 @GetMapping("/brand/id/{brand_id}")				//search a brand by Brand_Id, takes a brand_Id in parameters
	 public Optional <Brand> getoneBrand(@PathVariable("brand_id")int brand_id){
		 
		 if(!brandservice.getOneById(brand_id).isPresent())
	         throw new CosmeticaException(brand_id );
		 return brandservice.getOneById(brand_id);
		 
	 }
	 
	 @GetMapping("/brand/bn/{brandname}")				//search a brand by Brand_Name, takes a brand_Name in parameters
	 public List <Brand> BrandByBrandname(@PathVariable("brandname")String brandname){
		 
		 if(brandservice.getOneByBrandName(brandname).isEmpty())
	         throw new CosmeticaException(brandname);
		 return brandservice.getOneByBrandName(brandname);
		 
	 }

	 @PostMapping("/saller/add/brand")						//add a new brand , takes a brand in parameters
	 public void addBrand(@RequestBody Brand Brand) {
		 brandservice.saveOrUpdate(Brand);
		 
	 }
	 @PutMapping("/saller/modify/brand")					//modify a brand , takes the new brand in parameters
	 public void modifyBrand(@RequestBody Brand Brand) {
		 brandservice.saveOrUpdate(Brand);
		 
	 }
	 
	 @DeleteMapping("/saller/brand/remove/{brand_id}")		//remove a brand , takes a brand_Id in parameters
	 public void removeBrand(@PathVariable("brand_id")int brand_id) {
		 if(!brandservice.getOneById(brand_id).isPresent())
	         throw new CosmeticaException(brand_id );
		 Brand Brand = brandservice.getOneById(brand_id).get();
		 brandservice.delete(Brand); 
		 
	 }
	 
	 @GetMapping("/brand/coupons/id/{brand_id}")	//get a brand coupons by Brand_Id, takes a brand_Id in parameters
	 public List<Coupon> brandCouponsById(@PathVariable("brand_id")int brand_id) {
		 if(!brandservice.getOneById(brand_id).isPresent())
	         throw new CosmeticaException(brand_id );
		 Brand Brand = brandservice.getOneById(brand_id).get();
		 return brandservice.getBrandCoupons(Brand); 
	 }
	 
	 @GetMapping("/brand/coupons/bn/{brandname}")	//get a brand coupons by BrandName, takes a brand_Name in parameters
	 public List<Coupon> brandCouponsByBrandrname(@PathVariable("brandname")String brandname) {
		 if(brandservice.getOneByBrandName(brandname).isEmpty())
	         throw new CosmeticaException(brandname );
		 List<Brand> Brand = brandservice.getOneByBrandName(brandname);
		 return brandservice.getBrandCoupons(Brand.get(0)); 
	 }

	 @GetMapping("/brand/products/id/{brand_id}")	//get a brand products by Brand_Id, takes a brand_Id in parameters
	 public List<Product> brandProductsById(@PathVariable("brand_id")int brand_id) {
		 if(!brandservice.getOneById(brand_id).isPresent())
	         throw new CosmeticaException(brand_id );
		 Brand Brand = brandservice.getOneById(brand_id).get();
		 return brandservice.getBrandProducts(Brand); 
	 }
	 
	 @GetMapping("/brand/products/bn/{brandname}")	//get a brand products by Brand_Name, takes a brand_Name in parameters
	 public List<Product> brandProductsByUsername(@PathVariable("brandname")String brandname) {
		 if(brandservice.getOneByBrandName(brandname).isEmpty())
	         throw new CosmeticaException(brandname );
		 List<Brand> Brand = brandservice.getOneByBrandName(brandname);
		 return brandservice.getBrandProducts(Brand.get(0)); 
	 }

}
