package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Brand;

public interface IBrandDao extends JpaRepository<Brand , Integer>{

}
