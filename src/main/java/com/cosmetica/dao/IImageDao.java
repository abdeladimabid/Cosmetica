package com.cosmetica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.entities.Image;
@Repository
public interface IImageDao extends JpaRepository<Image, Integer>{

}
