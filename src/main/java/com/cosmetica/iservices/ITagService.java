package com.cosmetica.iservices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.entities.Product;
import com.cosmetica.entities.Tag;

public interface ITagService {
	
	public List<Tag> getAll();

	public Optional<Tag> getOneById(int id);

	public void saveOrUpdate(Tag tag);

	public void delete(Tag tag);
	
	public List<Product> getProductsWithTag(Tag tag);

}
