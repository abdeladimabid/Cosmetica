package com.cosmetica.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IReviewDao;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.Review;
import com.cosmetica.Entities.User;
import com.cosmetica.IServices.IReviewService;

@Service
public class ReviewService implements IReviewService{
	
	@Autowired
	IReviewDao dao;

	@Override
	public List<Review> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Review> getOneById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Review review) {
		dao.save(review);
	}

	@Override
	public void delete(Review review) {
		dao.delete(review);
	}

	@Override
	public User getReviewUser(Review review) {
		return review.getUser_review();
	}

	@Override
	public String getReviewTimeSincePublished(Review Review) {
		String result = null;
		
		Date now = new Date();
		Long diff = now.getTime() - Review.getInserted_at().getTime();
		
		diff = diff / 1000;

		long days = diff / (24 * 60 * 60);
		long hours = diff / (60 * 60) % 24;
		long minutes = diff / 60 % 60;
		long seconds = diff % 60;
		

		if(minutes <= 0 && hours <= 0 && days <= 0) {
			result = seconds + " seconds.";
		} else if(hours <= 0 && days <= 0) {
			result = minutes + " minutes, ";
			result += seconds + " seconds.";
		} else if (days <= 0) {
			result = hours + " hours, ";
			result += minutes + " minutes, ";
			result += seconds + " seconds.";

		} else {
			result = days + " days, ";
			result += hours + " hours, ";
			result += minutes + " minutes, ";
			result += seconds + " seconds.";
		}
		
		if(days < 30) {
			return result;
		} else {
			return null;
		}
		
	}

	@Override
	public Product getReviewProduct(Review review) {
		return review.getProduct_review();
	}
	


}
