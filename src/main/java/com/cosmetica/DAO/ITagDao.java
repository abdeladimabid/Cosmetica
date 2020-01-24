package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Tag;
@Repository
public interface ITagDao extends JpaRepository<Tag, Integer>{

}
