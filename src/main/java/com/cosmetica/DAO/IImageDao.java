package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Image;

public interface IImageDao extends JpaRepository<Image, Integer>{

}
