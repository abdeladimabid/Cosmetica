package com.cosmetica.services;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IReviewDao;
import com.cosmetica.entities.Client;
import com.cosmetica.entities.Review;
import com.cosmetica.iservices.IReviewService;

@Service
public class ReviewService implements IReviewService{
	
	@Autowired
	IReviewDao dao;

	@Override
	public List<Review> getAll() {
		return dao.findAll();
	}
	
	@Override
	public List<Review> getAllClient() {
		return dao.findAllClient();
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
	public Client getReviewUser(Review review) {
		return review.getUserReview();
	}

	@Override
	public String getReviewTimeSincePublished(Review review) {
		String result = null;
		ZonedDateTime now = ZonedDateTime.now();
		Long diff = now.toInstant().toEpochMilli()- review.getInsertedAt().getTime();
		
		diff = (diff + 3600000)/ 1000;

		long days = diff / (24 * 60 * 60);
		long hours = diff / (60 * 60) % 24;
		long minutes = diff / 60 % 60;
		long seconds = diff % 60;
		

		if(minutes <= 0 && hours <= 0 && days <= 0) {
			result = seconds + " second.";
		} else if(hours <= 0 && days <= 0) {
			result = minutes + " minutes ago ";
		} else if (days <= 0) {
			result = hours + " hours ago.";

		} else {
			result = days + " days ago.";
		}
		
		if(days < 30) {
			if(days<7) {
				return result;
			}else if(days>7 && days<17) {
				return "1 week ago.";
			}else if(days>14 && days<21) {
				return "2 weeks ago.";
			}else if(days>21 && days<28) {
				return "3 weeks ago.";
			}
		} else {
			SimpleDateFormat formater = new SimpleDateFormat("dd MMM");
		    return formater.format(review.getInsertedAt());
		}
		return null;
	}

	
//stars count f review insert

}
