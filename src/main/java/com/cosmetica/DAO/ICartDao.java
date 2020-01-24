package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Cart;
@Repository
public interface ICartDao extends JpaRepository<Cart, Integer>{

}
