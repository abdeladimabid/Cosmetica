package com.cosmetica.IServices;

import java.util.List;
import java.util.Optional;

import com.cosmetica.Entities.Tag;

public interface ITagService {
	
	public List<Tag> getAll();

	public Optional<Tag> getOneById(int id);

	public void saveOrUpdate(Tag tag);

	public void delete(Tag tag);

}
