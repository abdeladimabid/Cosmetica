package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Coupon;
@Repository
public interface ICouponDao extends JpaRepository<Coupon, Integer>{

}
