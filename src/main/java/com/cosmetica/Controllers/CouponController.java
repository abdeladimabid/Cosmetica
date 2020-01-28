package com.cosmetica.Controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cosmetica.IServices.ICouponService;

@RestController
@RequestMapping("COSMETICA")
public class CouponController {
	
	
	@Autowired
	ICouponService couponservice;
	
	 @GetMapping("/coupons")
	 public List<Coupon > allProducts() {
		List<Coupon> coupons = couponservice.getAll();
		return coupons;
		 
	 }
	 
	 @GetMapping("/coupon/{coupon_id}")
	 public Optional <Coupon> oneProduct(@PathVariable("coupon_id")int coupon_id){
		 if(!couponservice.getOneById(coupon_id).isPresent())
	         throw new CosmeticaException(coupon_id );
		 return couponservice.getOneById(coupon_id);
		 
	 }
	 
	 @GetMapping("/brand/coupon/{coupon_id}")
	 public Brand getBrandCoupon(@PathVariable("coupon_id")int coupon_id,Coupon Coupon) {
		 if(!couponservice.getOneById(coupon_id).isPresent())
	         throw new CosmeticaException(coupon_id );
		 Coupon coupon=couponservice.getOneById(coupon_id).get();
		 return couponservice.getBrand(coupon);
		 
	 }
	 
	 
	 
	 @PostMapping("/add/coupon")
	 public void addCoupon(@RequestBody Coupon coupon) {
//		 Date d = new Date();
//		 Coupon cou = couponservice.getOneById(1).get();
//		 Brand b = couponservice.getBrand(cou);
//		 Coupon c = new Coupon("code","description",false,20,d,null,b);
		 couponservice.saveOrUpdate(coupon);
		 
	 }
	 @PutMapping("/modify/coupon")
	 public void modifyCoupon(@RequestBody Coupon coupon) {
		 couponservice.saveOrUpdate(coupon);
		 
	 }
	 
	 @DeleteMapping("/remove/coupon/{coupon_id}")
	 public void removeProduct(@PathVariable("coupon_id")int coupon_id) {
		 if(!couponservice.getOneById(coupon_id).isPresent())
	         throw new CosmeticaException(coupon_id );
		 Coupon coupon=couponservice.getOneById(coupon_id).get();
		 couponservice.delete(coupon); 
		 
	 }
	 
	 
	 @GetMapping("/coupon/validation/{coupon_id}")
	 public boolean validationCoupon(@PathVariable("coupon_id")int coupon_id,Coupon Coupon) {
		 if(!couponservice.getOneById(coupon_id).isPresent())
	         throw new CosmeticaException(coupon_id );
		 Coupon coupon=couponservice.getOneById(coupon_id).get();
		 return couponservice.validateCoupon(coupon);
		 
		 
	 }

}
