package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Brand;
import com.cosmetica.entities.Coupon;

public interface ICouponService {
	
	public List<Coupon> getAll();

	public Optional<Coupon> getOneById(int id);

	public void saveOrUpdate(Coupon coupon);

	public void delete(Coupon coupon);
	
	public boolean validateCoupon(Coupon coupon);
	
	public Brand getBrand(Coupon coupon);

}
