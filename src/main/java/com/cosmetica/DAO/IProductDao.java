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
	List<Product> findByCategory(String category);
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
	@Query( value = "SELECT * FROM products p, tags t, product_tags pt WHERE p.product_id = pt.product_id AND t.tag_id = pt.tag_id AND p.category_id= ?1 AND p.stars>3 ORDER BY p.stars DESC LIMIT 1",
			nativeQuery = true)
			List<Product> getxpro(int id_category); //new method
}
