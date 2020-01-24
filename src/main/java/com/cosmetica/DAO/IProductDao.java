package com.cosmetica.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Product;
@Repository
public interface IProductDao extends JpaRepository<Product , Integer> {
//	Optional<Product> findByCategory(String category);

}
