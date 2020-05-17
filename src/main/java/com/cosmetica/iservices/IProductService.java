package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Image;
import com.cosmetica.entities.Product;
import com.cosmetica.entities.Review;
import com.cosmetica.entities.Tag;

public interface IProductService {
	
	public List<Product> getAll();

	public Optional<Product> getOneById(int id);

	public void saveOrUpdate(Product product);

	public void  delete(Product product);
	
	public List<Tag> getProductTags(Product product);
	
	public List<Image> getProductImages(Product product);
	
	public boolean productInStock(String ref);
	
	public List<Review> getProductReviews(Product product);

	public float getProductStars(Product product);
	
	public List<Product> getProductsBetween(double p1, double p2);

	public List<Product> getFeaturedProducts();
	
	public List<Product> getNewArrivals();
	
	public List<Product> getTopProducts();
	
	public List<Product> getHotDeals();
	
	public Product getDealOfTheDay();

	public List<Product> productsSuggestionX(Product product);

	public List<Product> productsSuggestionU(Product product);

	public List<Product> getCategoryProducts(int idCategory);

	public Optional<Product> getOneByRef(String ref);

	public List<Product> getAllClient();

	public List<Product> getByName(String name);
	
	public List<Product> getByNameA(String name);

	public List<Product> productsSuggestionC(Product product);

}
