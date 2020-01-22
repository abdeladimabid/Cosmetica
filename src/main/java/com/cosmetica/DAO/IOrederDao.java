package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Order;

public interface IOrederDao extends JpaRepository<Order, Integer>{

}
