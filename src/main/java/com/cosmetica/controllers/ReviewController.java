package com.cosmetica.controllers;

import java.util.List;

import java.util.Optional;

import org.modelmapper.ModelMapper;
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

import com.cosmetica.dto.ReviewDTO;
import com.cosmetica.entities.Client;
import com.cosmetica.entities.Product;
import com.cosmetica.entities.Review;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.exceptions.ItemDontExistException;
import com.cosmetica.iservices.IProductService;
import com.cosmetica.iservices.IReviewService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class ReviewController {
	
	
	@Autowired
	IReviewService reviewservice;
	IProductService productservice;
	
	@GetMapping("/supervisor/review/all")
	 public List<Review> allReviews() {
		return reviewservice.getAll();
		 
	 }
	
	@GetMapping("/review/all")
	public List<Review> allReviewsClient() {
		return reviewservice.getAllClient();
		
	}
	 
	 @GetMapping("/supervisor/review/{reviewId}")
	 public Optional <Review> oneReview(@PathVariable("reviewId")int reviewId){
		 
		 if(!reviewservice.getOneById(reviewId).isPresent())
	         throw new CosmeticaException(reviewId );
		 return reviewservice.getOneById(reviewId);
		 
	 }
	 
	 @GetMapping("/review/{reviewId}")
	 public Optional <Review> oneReviewClient(@PathVariable("reviewId")int reviewId){
		 
		 if(!reviewservice.getOneById(reviewId).isPresent())
			 throw new CosmeticaException(reviewId );
		 Review review = reviewservice.getOneById(reviewId).orElseThrow(() -> new CosmeticaException(reviewId));
		 if(review.getStatus()==1) {
			 return reviewservice.getOneById(reviewId);
		 } else throw new ItemDontExistException(reviewId);
		 
	 }

	 @PostMapping("/client/add/review")
	 public void addReview(@RequestBody ReviewDTO source) {
		 Review target = new Review();
		 ModelMapper model = new ModelMapper();
		 model.map(source, target);
		 reviewservice.saveOrUpdate(target);
		 
	 }
	 
	 @PutMapping("/client/modify/review")
	 public void modifyReview(@RequestBody ReviewDTO source) {
		 Review target = new Review();
		 ModelMapper modelv = new ModelMapper();
		 modelv.map(source, target);
		 reviewservice.saveOrUpdate(target);
		 
	 }
	 
	 @PostMapping("/supervisor/allow/review/{reviewId}")
	 public void allowReview(@PathVariable("reviewId")int reviewId) {
		 
		 if(!reviewservice.getOneById(reviewId).isPresent())
	         throw new CosmeticaException(reviewId);
		 Review review = reviewservice.getOneById(reviewId).orElseThrow(() -> new CosmeticaException(reviewId));
		 review.setStatus(1);
		 reviewservice.saveOrUpdate(review);
	 }
	 
	 @DeleteMapping("/client/review/remove/{reviewId}")
	 public void removeReview(@PathVariable("reviewId")int reviewId) {
		 if(!reviewservice.getOneById(reviewId).isPresent())
	         throw new CosmeticaException(reviewId );
		 Review review = reviewservice.getOneById(reviewId).orElseThrow(() -> new CosmeticaException(reviewId));
		 reviewservice.delete(review); 
		 
	 }

	 @GetMapping("/review/user/{reviewId}")
	 public Client userReviews(@PathVariable("reviewId")int reviewId) {
		 
		 if(!reviewservice.getOneById(reviewId).isPresent())
	         throw new CosmeticaException(reviewId );
		 Review review =reviewservice.getOneById(reviewId).orElseThrow(() -> new CosmeticaException(reviewId));
		 return reviewservice.getReviewUser(review);
		 
	 }
	 @GetMapping("/review/date/{reviewId}")
	 public String getReviewTimeSincePublished(@PathVariable("reviewId")int reviewId){
		 
		 if(!reviewservice.getOneById(reviewId).isPresent())
	         throw new CosmeticaException(reviewId );
		 Review review = reviewservice.getOneById(reviewId).orElseThrow(() -> new CosmeticaException(reviewId));
		 return reviewservice.getReviewTimeSincePublished(review);
		 
	 }
	//new method
	    @PostMapping("/supervisor/review/validate")                //validate an a review, takes an reviewId in parameters
	        public void validate(@RequestBody int id) {
	         if(!reviewservice.getOneById(id).isPresent())
	            throw new CosmeticaException(id);
	         Review review = reviewservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
	         review.setStatus(1);
	         reviewservice.saveOrUpdate(review);
	         Product product = review.getProductReview();
	         product.setStars(productservice.getProductStars(product));
	         productservice.saveOrUpdate(product);
	        }

	//new method
	    @PostMapping("/supervisor/review/invalidate")                //unvalidate a review, takes an reviewId in parameters
	        public void invalidate(@RequestBody int id) {
	        if(!reviewservice.getOneById(id).isPresent())
	            throw new CosmeticaException(id);
	        Review review = reviewservice.getOneById(id).orElseThrow(() -> new CosmeticaException(id));
	        review.setStatus(0);
	        reviewservice.saveOrUpdate(review);
			Product product = review.getProductReview();
			product.setStars(productservice.getProductStars(product));
			productservice.saveOrUpdate(product);

	        }
	 
}
