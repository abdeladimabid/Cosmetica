package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.DAO.IProductDao;
import com.cosmetica.Entities.Image;
import com.cosmetica.Entities.Product;
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
		return product.getProduct_tags();
	}
	
	public List<Image> getProductImages(Product product){
		return product.getImages();
	}
	
//	public Optional<Product> getProductByCategory(String category){
//		return dao.findByCategory(category);
//	}	
	
	public boolean productInStock(Product product) {
		List<Product> products = dao.findAll();
		for (Product p : products) {
			if(product.getProduct_ref()==p.getProduct_ref()) {
				return true;}
		}
				return false;
	}
	

}
