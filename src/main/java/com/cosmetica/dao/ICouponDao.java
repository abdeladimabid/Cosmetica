package com.cosmetica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Coupon;
@Repository
public interface ICouponDao extends JpaRepository<Coupon, Integer>{

}
