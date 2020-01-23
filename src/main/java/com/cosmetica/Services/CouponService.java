package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.ICouponDao;
import com.cosmetica.Entities.Coupon;
import com.cosmetica.IServices.ICouponService;

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

}
