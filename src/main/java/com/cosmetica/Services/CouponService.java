package com.cosmetica.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.ICouponDao;
import com.cosmetica.Entities.Brand;
import com.cosmetica.Entities.Coupon;
import com.cosmetica.IServices.ICouponService;

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
	public void saveOrUpdate(Coupon Coupon) {
		dao.save(Coupon);
	}

	@Override
	public void delete(Coupon Coupon) {
		dao.delete(Coupon);
	}
	
	@Override
	public Brand getBrand(Coupon Coupon) {
		return Coupon.getCouponBrand();
	}
	
	@Override
	public boolean validateCoupon(Coupon Coupon) {
		 Date now = new Date();
		 if(Coupon.getEndDate().before(now)) {
			 return false;
		 } else {
			 return true;
		 }
	}

}
