package com.cosmetica.controllers;

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

import com.cosmetica.entities.Tag;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.ITagService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class TagController {

	@Autowired
	ITagService tagService;
	
	@GetMapping("/saller/tag/all")						//get all tags
	 public List<Tag> allTags() {
		return tagService.getAll();
		 
	 }
	 
	 @GetMapping("/saller/tag/{tag_id}")				//get tag by id, id_tag is given in parameters
	 public Optional <Tag> oneTag(@PathVariable("tag_id")int tagId){
		 
		 if(!tagService.getOneById(tagId).isPresent())
	         throw new CosmeticaException(tagId );
		 return tagService.getOneById(tagId);
		 
	 }

	 @PostMapping("/saller/tag/add")					//add tag, new tag is given in parameters
	 public void addTag(@RequestBody Tag tag) {
		 tagService.saveOrUpdate(tag);
		 
	 }
	 
	 @PutMapping("/saller/tag/modify")					//modify tag, new tag is given in parameters
	 public void modifyTag(@RequestBody Tag tag) {
		 tagService.saveOrUpdate(tag); 
	 }
	 
	 @DeleteMapping("/saller/tag/remove/{tagId}")		//delete tag by id, id_tag is given in parameters
	 public void removeTag(@PathVariable("tagId")int tagId) {
		 if(!tagService.getOneById(tagId).isPresent())
	         throw new CosmeticaException(tagId );
		 Tag tag = tagService.getOneById(tagId).orElseThrow(() -> new CosmeticaException(tagId));
		 tagService.delete(tag); 
		 
	 }
	

}
