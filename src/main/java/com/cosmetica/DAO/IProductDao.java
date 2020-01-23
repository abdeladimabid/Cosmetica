package com.cosmetica.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Product;


public interface IProductDao extends JpaRepository<Product , Integer> {
	Optional<Product> findByCategory(String category);

}
