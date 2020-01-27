package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.Review;
import com.cosmetica.Entities.User;


public interface IReviewService {
	
	public List<Review> getAll();

	public Optional<Review> getOneById(int id);

	public void saveOrUpdate(Review categorie);

	public void delete(Review categorie);

	public User getReviewUser(Review review);
	
	public String getReviewTimeSincePublished(Review Review);
	
	public Product getReviewProduct(Review review);
	
	

}
