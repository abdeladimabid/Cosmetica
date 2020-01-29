package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IProductDao;
import com.cosmetica.Entities.Image;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.Review;
import com.cosmetica.Entities.Tag;
import com.cosmetica.IServices.IProductService;

@Service
public class ProductService implements IProductService{


	@Autowired
	IProductDao dao;

	@Override
	public List<Product> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Product> getOneById(int id){
		return dao.findById(id);
	}
	@Override
	public void saveOrUpdate(Product product) {
		dao.save(product);
	}

	@Override
	public void delete(Product product) {
		dao.delete(product);
	}
	
	@Override
	public List<Tag> getProductTags(Product product){
		return product.getProductTags();
	}
	
	public List<Review> getProductReviews(Product product){
		return product.getProductReviews();
	}
	public List<Image> getProductImages(Product product){
		return product.getImages();
	}
	
	public float getProductStars(Product product){
		int count=0;
		float stars=0;
		
		List<Review> reviews = product.getProductReviews();
		for (Review r : reviews) {
			count++;
			stars=stars+r.getStars();
		}
		stars=stars/count;
		return Precision.round(stars, 1);
	}
	
	public boolean productInStock(String ref) {
		if(!dao.findByProductRef(ref).isPresent()) return false;
		return true;
	}
	
	public List<Product> getProductsBetween(double p1, double p2){
		return dao.findByRegularPriceBetween(p1, p2);
	}
	
	public List<Product> getFeaturedProducts(){
		return dao.findByFeaturedNotLike(0);
	}
	
	public List<Product> getNewArrivals(){
		return dao.findAllOrderByInsertedAt();
	}
	
//	public List<Product> productsSuggestionX(Product product){
//		List<Product> products = dao.findByCategory(product.getProduct_category().getLabel());
//		List<Tag> tags;
//		int[][] matches;
//		for (Product p : products) {
//			tags=p.getProduct_tags();
//			tags.retainAll(product.getProduct_tags());
//				     
//				}
//					//make a table with product id and how many matching tags, 
//					//make a table with best 5 rated products and return it
//			
//			}
	

}
