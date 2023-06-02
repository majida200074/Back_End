package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.Restaurant;
import com.example.demo.Entity.Specialite;
import com.example.demo.Entity.Ville;
import com.example.demo.Repository.specialiteRepository;
import com.example.demo.Services.specialiteService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("specialites")
public class specialiteController {
	
	@Autowired
	private specialiteService specialiteservice;
	
	@GetMapping("/api/specialites")
	public List<Specialite> findAll(){
		return specialiteservice.findAll();
	}
	
	@PostMapping("/save")
	public Specialite save(@RequestBody Specialite specialite){
		return specialiteservice.save(specialite);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) int id){
	//Ville ville = villeservice.findById(Integer.parseInt(id));
	specialiteservice.delete(id);
	}
	@GetMapping("/findById/{id}")
	public Specialite findById(@PathVariable int id) {
		return specialiteservice.findById(id);
	}
	@PutMapping("/update/{id}")
	public Specialite update(@PathVariable int id,@RequestBody Specialite specialite) {
		return specialiteservice.update(id, specialite);
	}
	
	
}
