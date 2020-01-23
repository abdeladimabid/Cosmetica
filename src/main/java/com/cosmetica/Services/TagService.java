package com.cosmetica.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cosmetica.DAO.ITagDao;
import com.cosmetica.Entities.Tag;
import com.cosmetica.IServices.ITagService;

public class TagService implements ITagService{

	@Autowired
	ITagDao dao;

	@Override
	public List<Tag> getAll(){
		return dao.findAll();
	}

	@Override
	public Optional<Tag> getOneById(int id){
		return dao.findById(id);
	}

	@Override
	public void saveOrUpdate(Tag Tag) {
		dao.save(Tag);
	}

	@Override
	public void delete(Tag Tag) {
		dao.delete(Tag);
	}
	

}
