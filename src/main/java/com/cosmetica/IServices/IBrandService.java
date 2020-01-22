package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Brand;


public interface IBrandService {
	
	public List<Brand> getAll();

	public Optional<Brand> getOneById(int id);

	public void saveOrUpdate(Brand brand);

	public void delete(Brand brand);


}
