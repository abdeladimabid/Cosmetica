package com.cosmetica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetica.dao.ITagDao;
import com.cosmetica.entities.Product;
import com.cosmetica.entities.Tag;
import com.cosmetica.iservices.ITagService;

@Service
public class TagService implements ITagService{

	@Autowired
	ITagDao dao;

	@Override
	public List<Tag> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Tag> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Tag tag) {
		dao.save(tag);
	}

	@Override
	public void delete(Tag tag) {
		dao.delete(tag);
	}
	
	public List<Product> getProductsWithTag(Tag tag){
		return tag.getProducts();
	}

}
