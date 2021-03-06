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

import com.cosmetica.dto.CouponDTO;
import com.cosmetica.entities.Brand;
import com.cosmetica.entities.Coupon;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.exceptions.ItemDontExistException;
import com.cosmetica.iservices.ICouponService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class CouponController {
	
	
	@Autowired
	ICouponService couponservice;
	
	 @GetMapping("/saller/coupon/all")
	 public List<Coupon > allCoupons() {
		return couponservice.getAll();
		 
	 }
	 
	 @GetMapping("/saller/coupon/{couponId}")
	 public Optional <Coupon> oneCoupon(@PathVariable("couponId")int couponId){
		 if(!couponservice.getOneById(couponId).isPresent())
	         throw new CosmeticaException(couponId );
		 return couponservice.getOneById(couponId);
		 
	 }
	 
	 @GetMapping("/coupon/{couponId}")
	 public Optional <Coupon> clientoneCoupon(@PathVariable("couponId")int couponId){
		 if(!couponservice.getOneById(couponId).isPresent())
			 throw new CosmeticaException(couponId );
		 Coupon coupon = couponservice.getOneById(couponId).orElseThrow(() -> new CosmeticaException(couponId));
		 if(coupon.getActive()==1) {
				return couponservice.getOneById(couponId); 
			 }	else throw new ItemDontExistException(couponId);
	 
	 }
	 
	 @GetMapping("/saller/coupon/brand/{couponId}")
	 public Brand brandCoupon(@PathVariable("couponId")int couponId) {
		 if(!couponservice.getOneById(couponId).isPresent())
	         throw new CosmeticaException(couponId );
		 Coupon coupon=couponservice.getOneById(couponId).orElseThrow(() -> new CosmeticaException(couponId));
		 return couponservice.getBrand(coupon);
		 
	 }
	 
	 @GetMapping("/coupon/brand/{couponId}")
	 public Brand clientBrandCoupon(@PathVariable("couponId")int couponId) {
		 if(!couponservice.getOneById(couponId).isPresent())
			 throw new CosmeticaException(couponId );
		 Coupon coupon=couponservice.getOneById(couponId).orElseThrow(() -> new CosmeticaException(couponId));
		 if(coupon.getActive()==1) {
			return couponservice.getBrand(coupon); 
		 }	else throw new ItemDontExistException(couponId);
		
	 }
	 
	 @PostMapping("/saller/add/coupon")
	 public void addCoupon(@RequestBody CouponDTO source) {
		 Coupon target = new Coupon();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(source, target);
		 couponservice.saveOrUpdate(target);
		 
	 }
	 
	 @PutMapping("/saller/coupon/modify")
	 public void modifyCoupon(@RequestBody CouponDTO source) {
		 Coupon target = new Coupon();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 couponservice.saveOrUpdate(target);
		 
	 }
	 
	 @DeleteMapping("/saller/coupon/remove/{couponId}")
	 public void removeCoupon(@PathVariable("couponId")int couponId) {
		 if(!couponservice.getOneById(couponId).isPresent())
	         throw new CosmeticaException(couponId );
		 Coupon coupon=couponservice.getOneById(couponId).orElseThrow(() -> new CosmeticaException(couponId));
		 couponservice.delete(coupon); 
		 
	 }
	 
	 
	 @GetMapping("/saller/coupon/validation/{couponId}")
	 public boolean validationCoupon(@PathVariable("couponId")int couponId) {
		 if(!couponservice.getOneById(couponId).isPresent())
	         throw new CosmeticaException(couponId );
		 Coupon coupon=couponservice.getOneById(couponId).orElseThrow(() -> new CosmeticaException(couponId));
		 return couponservice.validateCoupon(coupon);
		  
	 }
	 
	//new method
	    @PostMapping("/saller/coupon/validate")                //validate an a coupon, takes an couponId in parameters
	        public void validate(@RequestBody int id) {
	         if(!couponservice.getOneById(id).isPresent())
	            throw new CosmeticaException(id);
	         Coupon coupon = couponservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
	         coupon.setActive(1);
	         couponservice.saveOrUpdate(coupon);

	        }

	//new method
	    @PostMapping("/saller/coupon/invalidate")                //unvalidate a coupon, takes an couponId in parameters
	        public void invalidate(@RequestBody int id) {
	        if(!couponservice.getOneById(id).isPresent())
	            throw new CosmeticaException(id);
	        Coupon coupon = couponservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
	        coupon.setActive(0);
	        couponservice.saveOrUpdate(coupon);

	        }
}
