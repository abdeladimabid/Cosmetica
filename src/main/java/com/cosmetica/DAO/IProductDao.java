package com.cosmetica.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Product;


public interface IProductDao extends JpaRepository<Product , Integer> {
	List<Product> findByCategory(String category);

}
