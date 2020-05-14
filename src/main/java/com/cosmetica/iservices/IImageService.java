package com.cosmetica.iservices;

import java.util.List;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.cosmetica.entities.Image;


public interface IImageService {
	
	public List<Image> getAll();

	public Optional<Image> getOneById(int id);

	public void saveOrUpdate(Image image);

	public void delete(Image image);
	
	public String getUploadDirectory();

	public void uploadImage(MultipartFile image) throws Exception;
	
}
