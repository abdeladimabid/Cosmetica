package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Coupon;

public interface ICouponService {
	
	public List<Coupon> getAll();

	public Optional<Coupon> getOneById(int id);

	public void saveOrUpdate(Coupon coupon);

	public void delete(Coupon coupon);

}
