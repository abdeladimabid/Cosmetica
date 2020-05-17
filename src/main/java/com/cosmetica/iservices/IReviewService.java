package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Client;
import com.cosmetica.entities.Review;


public interface IReviewService {
	
	public List<Review> getAll();

	public Optional<Review> getOneById(int id);

	public void saveOrUpdate(Review categorie);

	public void delete(Review categorie);

	public Client getReviewUser(Review review);
	
	public String getReviewTimeSincePublished(Review review);

	public List<Review> getAllClient();
	
	
	

}
