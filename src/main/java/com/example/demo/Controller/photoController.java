package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Photo;
import com.example.demo.Entity.Ville;
import com.example.demo.Services.photoService;

@RestController
@RequestMapping("photos")
public class photoController {
	@Autowired
	private photoService photoservice;
	
	@GetMapping("/api/photos")
	public List<Photo> findAll(){
		return photoservice.findAll();
	}
	
	@PostMapping("/save")
	public Photo save(@RequestBody Photo photo){
		return photoservice.save(photo);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) int id){
	//Ville ville = villeservice.findById(Integer.parseInt(id));
		photoservice.delete(id);
	}
	
	@GetMapping("/findById/{id}")
	public Photo findById(@PathVariable int id) {
		return photoservice.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public Photo update(@PathVariable int id,@RequestBody Photo photo) {
		Photo photos = photoservice.findById(id);
		if(photos != null) {
			photos.setUrl(photo.getUrl());
			photos.setRestaurant(photo.getRestaurant());
			return photoservice.save(photos);
		}
		return null;
	}
	
}
