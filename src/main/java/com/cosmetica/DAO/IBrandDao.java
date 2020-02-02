package com.cosmetica.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Brand;

@Repository
public interface IBrandDao extends JpaRepository<Brand , Integer>{

	List<Brand> findByNameContaining(String name);
	@Query( value = "SELECT * FROM brands ORDER BY inserted_at DESC",
			nativeQuery = true)
	List<Brand> findAllBrands();
}
