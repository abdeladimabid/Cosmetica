package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Category;

public interface ICategoryDao extends JpaRepository<Category , Integer>{

}
