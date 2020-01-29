package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Client;
import com.cosmetica.Entities.Review;


public interface IReviewService {
	
	public List<Review> getAll();

	public Optional<Review> getOneById(int id);

	public void saveOrUpdate(Review categorie);

	public void delete(Review categorie);

	public Client getReviewUser(Review review);
	
	public String getReviewTimeSincePublished(Review Review);
	
	
	

}
