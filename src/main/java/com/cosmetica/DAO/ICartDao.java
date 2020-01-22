package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Cart;

public interface ICartDao extends JpaRepository<Cart, Integer>{

}
