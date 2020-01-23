package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.IImageDao;
import com.cosmetica.Entities.Image;
import com.cosmetica.IServices.IImageService;

public class ImageService implements IImageService{

	@Autowired
	IImageDao dao;

	@Override
	public List<Image> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Image> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Image Image) {
		dao.save(Image);
	}

	@Override
	public void delete(Image Image) {
		dao.delete(Image);
	}
	
}
