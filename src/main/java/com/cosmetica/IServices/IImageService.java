package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Image;
import com.cosmetica.Entities.Product;

public interface IImageService {
	
	public List<Image> getAll();

	public Optional<Image> getOneById(int id);

	public void saveOrUpdate(Image image);

	public void delete(Image image);

	public Product getImagePost(Image image);
	
//	public void uploadImage(MultipartFile image) throws Exception;
	
	public String getUploadDirectory();
}
