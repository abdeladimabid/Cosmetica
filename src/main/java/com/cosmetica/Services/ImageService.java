package com.cosmetica.Services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetica.DAO.IImageDao;
import com.cosmetica.Entities.Image;
import com.cosmetica.IServices.IImageService;

@Service
public class ImageService implements IImageService{
	
	public static String uploadDirectory = System.getProperty("user.dir")+ "\\uploads";

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
	

	@Override
	public void uploadImage(MultipartFile imageFile) throws Exception{
		String folder = this.uploadDirectory+"\\";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + imageFile.getOriginalFilename());
		Files.write(path, bytes);
	}

	public String getUploadDirectory() {
		return uploadDirectory;
	}
	
}
