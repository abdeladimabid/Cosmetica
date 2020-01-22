package com.cosmetica.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetica.Entities.Review;

public interface IReviewDao extends JpaRepository<Review, Integer>{

}
