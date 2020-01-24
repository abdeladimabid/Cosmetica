package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Image;
@Repository
public interface IImageDao extends JpaRepository<Image, Integer>{

}
