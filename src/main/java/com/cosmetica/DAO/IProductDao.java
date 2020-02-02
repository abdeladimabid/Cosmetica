package com.cosmetica.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Product;
@Repository
public interface IProductDao extends JpaRepository<Product , Integer> {
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
	@Query( value = "SELECT * FROM products p WHERE p.category_id= ?1",
			nativeQuery = true)
			List<Product> findCategoryProducts(int id_category);
	@Query( value = "SELECT * FROM products p WHERE p.product_ref= ?1",
			nativeQuery = true)
			Optional<Product> findByProductRef(String ref);
	@Query( value = "SELECT * FROM products p WHERE p.category_id= (SELECT a.category_id FROM products a WHERE a.product_id= ?1) AND status=1 AND quantity>=1 AND product_id<>?1 AND p.stars>=3  ORDER BY p.stars DESC ",
			nativeQuery = true)
	       List<Product> getXSell(int id_product); 
	@Query( value = "SELECT * FROM products p WHERE p.category_id= (SELECT a.category_id FROM products a WHERE a.product_id= ?1) AND p.regular_price > (SELECT a.regular_price FROM products a WHERE a.product_id= ?1) "
			+ "AND status=1 AND quantity>=1 AND product_id<>?1 AND p.stars>=3  ORDER BY  p.regular_price DESC, p.stars DESC ",
			nativeQuery = true)
			List<Product> getUpSell(int id_product); 
}
