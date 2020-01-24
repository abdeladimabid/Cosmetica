package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Order;
@Repository
public interface IOrederDao extends JpaRepository<Order, Integer>{

}
