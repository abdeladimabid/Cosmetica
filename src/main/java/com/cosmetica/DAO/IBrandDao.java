package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Brand;
@Repository
public interface IBrandDao extends JpaRepository<Brand , Integer>{

}
