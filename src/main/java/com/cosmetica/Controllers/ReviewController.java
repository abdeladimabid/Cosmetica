package com.cosmetica.Controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cosmetica.Entities.Review;

import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IReviewService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class ReviewController {
	
	
	@Autowired
	IReviewService reviewservice;
	
	@GetMapping("/reviews")
	 public List<Review> allReviews() {
		List<Review> review = reviewservice.getAll();
		return review;
		 
	 }
	 
	 @GetMapping("/review/{review_id}")
	 public Optional <Review> oneReview(@PathVariable("review_id")int review_id){
		 
		 if(!reviewservice.getOneById(review_id).isPresent())
	         throw new CosmeticaException(review_id );
		 return reviewservice.getOneById(review_id);
		 
	 }

	 @PostMapping("/add/review")
	 public void addReview(@RequestBody Review review) {
		 reviewservice.saveOrUpdate(review);
		 
	 }
	 @PutMapping("/modify/review")
	 public void modifyReview(@RequestBody Review review) {
		 reviewservice.saveOrUpdate(review);
		 
	 }
	 
	 @DeleteMapping("/remove/review/{review_id}")
	 public void removeReview(@PathVariable("review_id")int review_id) {
		 if(!reviewservice.getOneById(review_id).isPresent())
	         throw new CosmeticaException(review_id );
		 Review review = reviewservice.getOneById(review_id).get();
		 reviewservice.delete(review); 
		 
	 }

//	 @GetMapping("/review/user/{review_id}")//hna reviews ma3erfnash lou luser dyalou
//	 public Client userReviews(@PathVariable("review_id")int review_id) {
//		 
//		 if(!reviewservice.getOneById(review_id).isPresent())
//	         throw new CosmeticaException(review_id );
//		 Review review =reviewservice.getOneById(review_id).get();
//		 return reviewservice.getReviewUser(review);
//		 
//	 }
	 @GetMapping("/review/date/{review_id}")
	 public String getReviewTimeSincePublished(@PathVariable("review_id")int review_id){
		 
		 if(!reviewservice.getOneById(review_id).isPresent())
	         throw new CosmeticaException(review_id );
		 Review review = reviewservice.getOneById(review_id).get();
		 return reviewservice.getReviewTimeSincePublished(review);
		 
	 }
	 
}
