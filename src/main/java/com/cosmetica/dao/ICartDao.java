package com.cosmetica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Cart;
@Repository
public interface ICartDao extends JpaRepository<Cart, Integer>{

}
