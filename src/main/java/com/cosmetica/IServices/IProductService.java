package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Image;
import com.cosmetica.Entities.Product;
import com.cosmetica.Entities.Review;
import com.cosmetica.Entities.Tag;

public interface IProductService {
	
	public List<Product> getAll();

	public Optional<Product> getOneById(int id);

	public void saveOrUpdate(Product product);

	public void delete(int product_id);
	
	public List<Tag> getProductTags(Product product);
	
	public List<Image> getProductImages(Product product);
	
	public boolean productInStock(String ref);
	
	public List<Review> getProductReviews(Product product);
	
	public float getProductStars(Product product);
  


}
