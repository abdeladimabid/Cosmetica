package com.cosmetica.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetica.dao.IImageDao;
import com.cosmetica.entities.Image;
import com.cosmetica.iservices.IImageService;

@Service
public class ImageService implements IImageService{
	
	static final String UPLOADDIRECTORY = System.getProperty("user.dir")+ "\\uploads";

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
	public void saveOrUpdate(Image image) {
		dao.save(image);
	}

	@Override
	public void delete(Image image) {
		dao.delete(image);
	}
	

	@Override
	public void uploadImage(MultipartFile imageFile) throws Exception{
		String folder = ImageService.UPLOADDIRECTORY+"\\";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + imageFile.getOriginalFilename());
		Files.write(path, bytes);
	}

	public String getUploadDirectory() {
		return UPLOADDIRECTORY;
	}
	
}
