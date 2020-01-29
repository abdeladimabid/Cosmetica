package com.cosmetica.Controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetica.Entities.Image;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.IImageService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class ImageController {
	@Autowired
	IImageService imgservice;
	
	 @GetMapping("/images")
	 public List<Image> allImages() {
		List<Image> imgs = imgservice.getAll();
		return imgs;
		 
	 }
	 
	 @GetMapping("/image/{image_id}")
	 public Optional <Image> oneImage(@PathVariable("image_id")int image_id){
		 
		 if(!imgservice.getOneById(image_id).isPresent())
	         throw new CosmeticaException(image_id );
		 return imgservice.getOneById(image_id);
	
	 }

	 @PostMapping("/upload/image")
	 public void addImage(@RequestBody MultipartFile image) throws Exception {
		 imgservice.uploadImage(image);;
		 
	 }
	 
	 
	 @GetMapping("/image/dir")
	 public String imageDir(){

		 return imgservice.getUploadDirectory();
	
	 }
	 
	 @DeleteMapping("/remove/{image_id}")
	 public void removeImage(@PathVariable("image_id")int image_id) {
		 if(!imgservice.getOneById(image_id).isPresent())
	         throw new CosmeticaException(image_id );
		 Image img = imgservice.getOneById(image_id).get();
		 imgservice.delete(img); 
		 
	 }
	
	

}
