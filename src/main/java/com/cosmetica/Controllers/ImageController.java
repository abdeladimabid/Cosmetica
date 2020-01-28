package com.cosmetica.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		List<Image> img = imgservice.getAll();
		return img;
		 
	 }
	 
	 @GetMapping("/image/{image_id}")
	 public Optional <Image> oneImage(@PathVariable("image_id")int image_id){
		 
		 if(!imgservice.getOneById(image_id).isPresent())
	         throw new CosmeticaException(image_id );
		 return imgservice.getOneById(image_id);
		 
	 }

	 @PostMapping("/add/image")
	 public void addImage(@RequestBody Image img) {
		 imgservice.saveOrUpdate(img);
		 
	 }
	 @PutMapping("/modify/image")
	 public void modifyImage(@RequestBody Image img) {
		 imgservice.saveOrUpdate(img);
		 
	 }
	 
	 @DeleteMapping("/remove/image/{image_id}")
	 public void removeImage(@PathVariable("image_id")int image_id) {
		 if(!imgservice.getOneById(image_id).isPresent())
	         throw new CosmeticaException(image_id );
		 Image img = imgservice.getOneById(image_id).get();
		 imgservice.delete(img); 
		 
	 }
	
	

}
