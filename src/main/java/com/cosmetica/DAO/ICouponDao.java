package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Coupon;

public interface ICouponDao extends JpaRepository<Coupon, Integer>{

}
