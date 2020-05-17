package com.cosmetica.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.IProductDao;
import com.cosmetica.entities.Category;
import com.cosmetica.entities.Image;
import com.cosmetica.entities.Match;
import com.cosmetica.entities.Product;
import com.cosmetica.entities.Review;
import com.cosmetica.entities.Tag;
import com.cosmetica.iservices.IProductService;

@Service
public class ProductService implements IProductService{


	@Autowired
	IProductDao dao;

	@Override
	public List<Product> getAll(){
		return dao.findAll();
	}
	
	@Override
	public List<Product> getAllClient(){
		return dao.findAllClient();
	}

	@Override
	public Optional<Product> getOneById(int id){
		return dao.findById(id);
	}
	
	@Override
	public Optional<Product> getOneByRef(String ref){
		return dao.findByProductRef(ref);
	}
	
	@Override
	public List<Product> getByName(String name){
		return dao.findName(name);
	}
	@Override
	public List<Product> getByNameA(String name){
		return dao.findNameAdmin(name);
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
			if(r.getStatus()==1) {
			count++;
			stars=stars+r.getStars();}
		}
		if(count!=0)stars=stars/count;
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

	@Override
	public List<Product> getTopProducts() {
		return dao.findTopProducts();
	}

	@Override
	public List<Product> getHotDeals() {
		return dao.findHotDeals();
	}

	@Override
	public Product getDealOfTheDay() {
		return dao.findDealOfTheDay();
	}
	
	@Override
	public List<Product> getCategoryProducts(int idCategory){
		return dao.findCategoryProducts(idCategory);
	}
	
	//new method
    @Override
    public List<Product> productsSuggestionX(Product product){
        List<Product> products = dao.getXSell(product.getProductId());
        List<Match> matches = new ArrayList<>();
        List<Match> primary = new ArrayList<>();
        
        for (Product p : products) {				//create an arraylist that contains the Query returned products _as table.Match_ and how many Tag matches _as table.tag_ they have with the product given in parameters
            List<Tag> tags = p.getProductTags();
            tags.retainAll(product.getProductTags());
            Match match = new Match();
            match.setMatch(p);
            match.setTags(tags.size());
            matches.add(match);
            }
        
        for (Match m : matches) {					//retain every product that has more than 3 tags and rated with more than 3 stars and store them in primary table
        	if(m.getTags()>=3 && m.getMatch().getStars()>=3) {
        		primary.add(m);
        	}
        }
        							     
        primary = primary.stream().limit(10).collect(Collectors.toList());
        products = new ArrayList<>();
        
        for(Match m : primary) {	
        		products.add(m.getMatch());}

        
        Collections.sort(products, Collections.reverseOrder());	//sort the primary table by matching tags
        return products;

            }
    
    //new method
    @Override
    public List<Product> productsSuggestionU(Product product){
    	List<Product> products = dao.getUpSell(product.getProductId());
    	List<Match> matches = new ArrayList<>();
    	List<Match> primary = new ArrayList<>();
    	
    	for (Product p : products) {				//create an arraylist that contains the Query returned products _as table.Match_ and how many Tag matches _as table.tag_ they have with the product given in parameters
    		List<Tag> tags = p.getProductTags();
    		tags.retainAll(product.getProductTags());
    		Match match = new Match();
    		match.setMatch(p);
    		match.setTags(tags.size());
    		matches.add(match);
    	}
    	
    	matches = matches.stream().limit(500).collect(Collectors.toList());
    	
    	for (Match m : matches) {					//retain every product that has more than 3 tags and rated with more than 3 stars and store them in primary table
    		if(m.getTags()>=3 && m.getMatch().getStars()>=3 && m.getMatch().getRegularPrice()>product.getRegularPrice()) {
    			primary.add(m);
    		}
    	}
    	
    	products = new ArrayList<>();
    	
    	for(Match m : primary) {	
    		products.add(m.getMatch());}
    	
    	Collections.sort(products, Collections.reverseOrder());	
    	
    	products = products.stream().limit(10).collect(Collectors.toList());
    	
    	return products;
    	
    }
    
    //new method
    @Override
    public List<Product> productsSuggestionC(Product product){  // You may also need, complimentary products suggestion
    	Category category = product.getProductCategory();
    	Category parent = category.getParent();
    	List<Product> products = new ArrayList<>();
    	List<Category> children = new ArrayList<>();

    		while(parent!=null) {
    			children.add(parent);
    			parent=parent.getParent();
    			
    		} 
    	
    	for(Category c : children) {
    		products.add(dao.getCSell(c.getCategoryId()));
    	}
    	
    	return products;
    	
    }

}
