package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetica.Entities.Review;
@Repository
public interface IReviewDao extends JpaRepository<Review, Integer>{

}
