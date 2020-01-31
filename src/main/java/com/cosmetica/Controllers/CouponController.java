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
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.ICouponService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class CouponController {
	
	
	@Autowired
	ICouponService couponservice;
	
	 @GetMapping("/saller/coupon/all")
	 public List<Coupon > allCoupons() {
		List<Coupon> coupons = couponservice.getAll();
		return coupons;
		 
	 }
	 
	 @GetMapping("/coupon/{coupon_id}")
	 public Optional <Coupon> oneCoupon(@PathVariable("coupon_id")int coupon_id){
		 if(!couponservice.getOneById(coupon_id).isPresent())
	         throw new CosmeticaException(coupon_id );
		 return couponservice.getOneById(coupon_id);
		 
	 }
	 
	 @GetMapping("/coupon/brand/{coupon_id}")
	 public Brand BrandCoupon(@PathVariable("coupon_id")int coupon_id,Coupon Coupon) {
		 if(!couponservice.getOneById(coupon_id).isPresent())
	         throw new CosmeticaException(coupon_id );
		 Coupon coupon=couponservice.getOneById(coupon_id).get();
		 return couponservice.getBrand(coupon);
		 
	 }
	 
	 @PostMapping("/saller/add/coupon/add")
	 public void addCoupon(@RequestBody Coupon coupon) {
		 couponservice.saveOrUpdate(coupon);
		 
	 }
	 
	 @PutMapping("/saller/coupon/modify")
	 public void modifyCoupon(@RequestBody Coupon coupon) {
		 couponservice.saveOrUpdate(coupon);
		 
	 }
	 
	 @DeleteMapping("/saller/coupon/remove/{coupon_id}")
	 public void removeCoupon(@PathVariable("coupon_id")int coupon_id) {
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
	 
	 @PostMapping("/saller/activate/{coupon_id}")
	 public void activateCoupon(@PathVariable("coupon_id")int coupon_id) {
		 if(!couponservice.getOneById(coupon_id).isPresent())
	         throw new CosmeticaException(coupon_id );
		 Coupon coupon=couponservice.getOneById(coupon_id).get();
		 coupon.setActive(1);
		 
	 }
	 
	 @PostMapping("/saller/deactivate/{coupon_id}")
	 public void deactivateCoupon(@PathVariable("coupon_id")int coupon_id) {
		 if(!couponservice.getOneById(coupon_id).isPresent())
	         throw new CosmeticaException(coupon_id );
		 Coupon coupon=couponservice.getOneById(coupon_id).get();
		 coupon.setActive(0);
		 
	 }

	//new method
	    @PostMapping("/coupon/validate")                //validate an a coupon, takes an coupon_id in parameters
	        public void validate(@RequestBody int id) {
	         if(!couponservice.getOneById(id).isPresent())
	            throw new CosmeticaException(id);
	         Coupon coupon = couponservice.getOneById(id).get();
	         coupon.setActive(1);;
	         couponservice.saveOrUpdate(coupon);

	        }

	//new method
	    @PostMapping("/coupon/invalidate")                //unvalidate a coupon, takes an coupon_id in parameters
	        public void invalidate(@RequestBody int id) {
	        if(!couponservice.getOneById(id).isPresent())
	            throw new CosmeticaException(id);
	        Coupon coupon = couponservice.getOneById(id).get();
	        coupon.setActive(0);;
	        couponservice.saveOrUpdate(coupon);
	        }
}
