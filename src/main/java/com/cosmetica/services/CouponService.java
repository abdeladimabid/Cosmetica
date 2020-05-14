package com.cosmetica.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.ICouponDao;
import com.cosmetica.entities.Brand;
import com.cosmetica.entities.Coupon;
import com.cosmetica.iservices.ICouponService;

@Service
public class CouponService implements ICouponService{

	@Autowired
	ICouponDao dao;

	@Override
	public List<Coupon> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Coupon> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Coupon coupon) {
		dao.save(coupon);
	}

	@Override
	public void delete(Coupon coupon) {
		dao.delete(coupon);
	}
	
	@Override
	public Brand getBrand(Coupon coupon) {
		return coupon.getCouponBrand();
	}
	
	@Override
	public boolean validateCoupon(Coupon coupon) {
		 Date now = new Date();
		 if(coupon.getEndDate().before(now)) {
			 return false;
		 } else {
			 return true;
		 }
	}

}
