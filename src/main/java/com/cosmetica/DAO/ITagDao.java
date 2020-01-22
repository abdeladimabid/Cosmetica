package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Tag;

public interface ITagDao extends JpaRepository<Tag, Integer>{

}
