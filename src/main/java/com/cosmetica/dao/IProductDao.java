package com.cosmetica.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Product;
@Repository
public interface IProductDao extends JpaRepository<Product , Integer> {
	List<Product> findByRegularPriceBetween(double p1, double p2);
	List<Product> findByFeaturedNotLike(int o);
	@Query( value = "SELECT * FROM products WHERE product_name LIKE '%?1%' AND status = 1 AND quantity > 0",
			nativeQuery = true)
			List<Product> findName(String name);
	@Query( value = "SELECT * FROM products WHERE product_name LIKE '%?1%'",
			nativeQuery = true)
			List<Product> findNameAdmin(String name);
	@Query( value = "SELECT * FROM products WHERE status = 1",
			nativeQuery = true)
			List<Product> findAllClient();
	@Query( value = "SELECT * FROM products WHERE status = 1 AND quantity > 0 ORDER BY inserted_at DESC LIMIT 10",
			nativeQuery = true)
			List<Product> findAllOrderByInsertedAt();
	@Query( value = "SELECT * FROM products WHERE status = 1 AND quantity > 0 ORDER BY stars DESC LIMIT 10",
			nativeQuery = true)
			List<Product> findTopProducts();
	@Query( value = "SELECT * FROM products WHERE status = 1 AND quantity > 0 ORDER BY discount DESC LIMIT 10",
			nativeQuery = true)
			List<Product> findHotDeals();
	@Query( value = "SELECT * FROM products WHERE status = 1 AND quantity > 0 ORDER BY discount DESC LIMIT 1",
			nativeQuery = true)
			Product findDealOfTheDay();
	@Query( value = "SELECT * FROM products p WHERE p.category_id= ?1 AND status = 1 AND quantity >= 1",
			nativeQuery = true)
			List<Product> findCategoryProducts(int idCategory);
	@Query( value = "SELECT * FROM products p WHERE p.product_ref= ?1",
			nativeQuery = true)
			Optional<Product> findByProductRef(String ref);
	@Query( value = "SELECT * FROM products p WHERE p.category_id= (SELECT a.category_id FROM products a WHERE a.product_id= ?1) AND p.status=1 AND p.quantity>=1 AND p.product_id<>?1 AND p.stars>=3  ORDER BY p.stars DESC LIMIT 1000",
			nativeQuery = true)
	       List<Product> getXSell(int idProduct); 
	@Query( value = "SELECT * FROM products p WHERE p.category_id= (SELECT a.category_id FROM products a WHERE a.product_id= ?1) AND p.regular_price > (SELECT a.regular_price FROM products a WHERE a.product_id= ?1) "
			+ "AND status=1 AND quantity>=1 AND product_id<>?1 AND p.stars>=3  ORDER BY  p.regular_price DESC, p.stars DESC LIMIT 1000",
			nativeQuery = true)
			List<Product> getUpSell(int idProduct); 
	@Query( value = "SELECT * FROM products p WHERE p.category_id= ?1 AND p.status=1 AND p.quantity>=1 AND p.category_id= ?1 AND p.stars>3  ORDER BY p.stars DESC LIMIT 1",
			nativeQuery = true)
	       Product getCSell(int idCategory); 
}
