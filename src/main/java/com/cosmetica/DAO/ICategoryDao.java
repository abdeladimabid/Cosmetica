package com.cosmetica.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category , Integer>{
	List<Category> findByParentIsNull();
}
