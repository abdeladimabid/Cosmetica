package com.cosmetica.controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetica.entities.Image;
import com.cosmetica.entities.Product;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IImageService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class ImageController {
	@Autowired
	IImageService imgservice;
	
	 @GetMapping("/image/all")
	 public List<Image> allImages() {
		return imgservice.getAll();
		 
	 }
	 
	 @GetMapping("/image/{imageId}")
	 public Optional <Image> oneImage(@PathVariable("imageId")int imageId){
		 
		 if(!imgservice.getOneById(imageId).isPresent())
	         throw new CosmeticaException(imageId );
		 return imgservice.getOneById(imageId);
	
	 }

	 @PostMapping("/saller/upload/image")
	 public void addImage(@RequestPart("file") MultipartFile image){
		 try {
			imgservice.uploadImage(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 
	 @GetMapping("/saller/image/dir")
	 public String imageDir(){

		 return imgservice.getUploadDirectory();
	
	 }
	 
	 @DeleteMapping("/saller/remove/{imageId}")
	 public void removeImage(@PathVariable("imageId")int imageId) {
		 if(!imgservice.getOneById(imageId).isPresent())
	         throw new CosmeticaException(imageId );
		 Image img = imgservice.getOneById(imageId).orElseThrow(() -> new CosmeticaException(imageId));
		 imgservice.delete(img); 
		 
	 }
	//new method
     @GetMapping("/image/product/{imageId}")
     public Product productImage(@PathVariable("imageId")int imageId){

         if(!imgservice.getOneById(imageId).isPresent())
             throw new CosmeticaException(imageId );

         Image image = imgservice.getOneById(imageId).orElseThrow(() -> new CosmeticaException(imageId));
         return image.getProductImage();

     }
	
	

}
