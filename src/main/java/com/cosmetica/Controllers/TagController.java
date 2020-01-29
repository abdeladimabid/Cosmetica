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

import com.cosmetica.Entities.Tag;
import com.cosmetica.Exceptions.CosmeticaException;
import com.cosmetica.IServices.ITagService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class TagController {

	@Autowired
	ITagService tagservice;
	
	@GetMapping("/tags")
	 public List<Tag> allTags() {
		List<Tag> Tags = tagservice.getAll();
		return Tags;
		 
	 }
	 
	 @GetMapping("/tag/{tag_id}")
	 public Optional <Tag> oneTag(@PathVariable("tag_id")int tag_id){
		 
		 if(!tagservice.getOneById(tag_id).isPresent())
	         throw new CosmeticaException(tag_id );
		 return tagservice.getOneById(tag_id);
		 
	 }

	 @PostMapping("/add/tag")
	 public void addTag(@RequestBody Tag Tag) {
		 tagservice.saveOrUpdate(Tag);
		 
	 }
	 @PutMapping("/modify/tag")
	 public void modifyTag(@RequestBody Tag Tag) {
		 tagservice.saveOrUpdate(Tag); 
	 }
	 
	 @DeleteMapping("/remove/tag/{tag_id}")
	 public void removeTag(@PathVariable("tag_id")int tag_id) {
		 if(!tagservice.getOneById(tag_id).isPresent())
	         throw new CosmeticaException(tag_id );
		 Tag Tag = tagservice.getOneById(tag_id).get();
		 tagservice.delete(Tag); 
		 
	 }
	

}
