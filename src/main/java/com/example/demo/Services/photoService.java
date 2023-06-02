package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.IDao;
import com.example.demo.Entity.Photo;
import com.example.demo.Repository.photoRepository;

@Service
public class photoService implements IDao<Photo>{

	@Autowired
	private photoRepository photorepository;
	
	
	@Override
	public Photo findById(int id) {
		return photorepository.findById(id);
	}

	@Override
	public List<Photo> findAll() {
		return photorepository.findAll();
	}

	@Override
	public Photo update(int id,Photo o) {
		Photo photo = photorepository.findById(id);
		photo.setUrl(o.getUrl());
		photo.setRestaurant(o.getRestaurant());
		return photorepository.save(photo);
		
	}

	@Override
	public void delete(int id) {
		Photo photo = photorepository.findById(id);
		photorepository.delete(photo);
	}

	@Override
	public Photo save(Photo o) {
		return photorepository.save(o);
	}

}
