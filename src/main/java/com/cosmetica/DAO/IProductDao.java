package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Product;
@Repository
public interface IProductDao extends JpaRepository<Product , Integer> {
	Optional<Product> findByProductRef(String ref);
	List<Product> findByRegularPriceBetween(double p1, double p2);
	List<Product> findByFeaturedNotLike(int o);
	@Query( value = "SELECT * FROM products ORDER BY inserted_at DESC LIMIT 10",
			nativeQuery = true)
			List<Product> findAllOrderByInsertedAt();
	@Query( value = "SELECT * FROM products ORDER BY stars DESC LIMIT 10",
			nativeQuery = true)
			List<Product> findTopProducts();
	@Query( value = "SELECT * FROM products ORDER BY discount DESC LIMIT 10",
			nativeQuery = true)
			List<Product> findHotDeals();
	@Query( value = "SELECT * FROM products ORDER BY discount DESC LIMIT 1",
			nativeQuery = true)
			Product findDealOfTheDay();
}
