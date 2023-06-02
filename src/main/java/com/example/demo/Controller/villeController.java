package com.example.demo.Controller;

import java.util.List;

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

import com.example.demo.Entity.Ville;
import com.example.demo.Services.villeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("villes")
public class villeController {
	
	@Autowired
	villeService villeservice;
	
	// Récupération de toutes les villes
	@GetMapping("/api/villes")
	public List<Ville> findAll(){
		return villeservice.findAll();
	}
	
	@PostMapping("/save")
	public Ville save(@RequestBody Ville ville){
		return villeservice.save(ville);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) int id){
	//Ville ville = villeservice.findById(Integer.parseInt(id));
	villeservice.delete(id);
	}
	
	@GetMapping("/findById/{id}")
	public Ville findById(@PathVariable int id) {
		return villeservice.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public Ville update(@PathVariable int id,@RequestBody Ville ville) {
		return villeservice.update(id, ville);
	}
	

}
