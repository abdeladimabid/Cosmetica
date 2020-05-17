package com.cosmetica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Brand;

@Repository
public interface IBrandDao extends JpaRepository<Brand , Integer>{

	List<Brand> findByNameContaining(String name);
}
