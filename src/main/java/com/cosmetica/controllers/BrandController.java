package com.cosmetica.controllers;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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

import com.cosmetica.dto.BrandDTO;
import com.cosmetica.entities.Brand;
import com.cosmetica.entities.Coupon;
import com.cosmetica.entities.Product;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IBrandService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class BrandController {
	
	@Autowired
	IBrandService brandservice;
	
	@GetMapping("/brand/all")							//get all brands
	 public List<Brand> allBrands() {
		return brandservice.getAll();
		 
	 }
	 
	 @GetMapping("/brand/id/{brand_id}")				//search a brand by Brand_Id, takes a brand_Id in parameters
	 public Optional <Brand> getoneBrand(@PathVariable("brand_id")int brandId){
		 
		 if(!brandservice.getOneById(brandId).isPresent())
	         throw new CosmeticaException(brandId );
		 return brandservice.getOneById(brandId);
		 
	 }
	 
	 @GetMapping("/brand/bn/{brandname}")				//search a brand by Brand_Name, takes a brand_Name in parameters
	 public List <Brand> brandByBrandname(@PathVariable("brandname")String brandname){
		 
		 if(brandservice.getOneByBrandName(brandname).isEmpty())
	         throw new CosmeticaException(brandname);
		 return brandservice.getOneByBrandName(brandname);
		 
	 }

	 @PostMapping("/saller/add/brand")						//add a new brand , takes a brand in parameters
	 public void addBrand(@RequestBody BrandDTO source) {
		 Brand target = new Brand();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 brandservice.saveOrUpdate(target);
	 }
	 @PutMapping("/saller/modify/brand")					//modify a brand , takes the new brand in parameters
	 public void modifyBrand(@RequestBody BrandDTO source) {
		Brand target = new Brand();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(source, target);
		 brandservice.saveOrUpdate(target);
	 }
	 
	 @DeleteMapping("/saller/brand/remove/{brand_id}")		//remove a brand , takes a brand_Id in parameters
	 public void removeBrand(@PathVariable("brand_id")int brandId) {
		 if(!brandservice.getOneById(brandId).isPresent())
	         throw new CosmeticaException(brandId );
		 Brand brand = brandservice.getOneById(brandId).orElseThrow(() -> new CosmeticaException(brandId));
		 brandservice.delete(brand); 
		 
	 }
	 
	 @GetMapping("/brand/coupons/id/{brand_id}")	//get a brand coupons by Brand_Id, takes a brand_Id in parameters
	 public List<Coupon> brandCouponsById(@PathVariable("brand_id")int brandId) {
		 if(!brandservice.getOneById(brandId).isPresent())
	         throw new CosmeticaException(brandId );
		 Brand brand = brandservice.getOneById(brandId).orElseThrow(() -> new CosmeticaException(brandId));
		 return brandservice.getBrandCoupons(brand); 
	 }
	 
	 @GetMapping("/brand/coupons/bn/{brandname}")	//get a brand coupons by BrandName, takes a brand_Name in parameters
	 public List<Coupon> brandCouponsByBrandrname(@PathVariable("brandname")String brandname) {
		 if(brandservice.getOneByBrandName(brandname).isEmpty())
	         throw new CosmeticaException(brandname );
		 List<Brand> brand = brandservice.getOneByBrandName(brandname);
		 return brandservice.getBrandCoupons(brand.get(0)); 
	 }

	 @GetMapping("/brand/products/id/{brand_id}")	//get a brand products by Brand_Id, takes a brand_Id in parameters
	 public List<Product> brandProductsById(@PathVariable("brand_id")int brandId) {
		 if(!brandservice.getOneById(brandId).isPresent())
	         throw new CosmeticaException(brandId );
		 Brand brand = brandservice.getOneById(brandId).orElseThrow(() -> new CosmeticaException(brandId));
		 return brandservice.getBrandProducts(brand); 
	 }
	 
	 @GetMapping("/brand/products/bn/{brandname}")	//get a brand products by Brand_Name, takes a brand_Name in parameters
	 public List<Product> brandProductsByUsername(@PathVariable("brandname")String brandname) {
		 if(brandservice.getOneByBrandName(brandname).isEmpty())
	         throw new CosmeticaException(brandname );
		 List<Brand> brand = brandservice.getOneByBrandName(brandname);
		 return brandservice.getBrandProducts(brand.get(0)); 
	 }

}
