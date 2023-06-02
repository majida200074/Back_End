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

import com.example.demo.Entity.Restaurant;
import com.example.demo.Entity.Serie;
import com.example.demo.Entity.Ville;
import com.example.demo.Repository.serieRepository;
import com.example.demo.Services.serieService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("series")
public class serieController {
	@Autowired
	 serieService serieservice;
	
	@GetMapping("/api/series")
	public List<Serie> findAll(){
		return serieservice.findAll();
	}
	
	@PostMapping("/save")
	public Serie save(@RequestBody Serie serie){
		return serieservice.save(serie);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) int id){
	//Ville ville = villeservice.findById(Integer.parseInt(id));
		serieservice.delete(id);
	}
	@GetMapping("/findById/{id}")
	public Serie findById(@PathVariable int id) {
		return serieservice.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public Serie update(@PathVariable int id,@RequestBody Serie serie) {
		return serieservice.update(id, serie);
	}
	
	
	
	/*@GetMapping("/series/{serie}")
	public ResponseEntity<String> findByNom(@PathVariable String serie){
		Serie series = serierepository.findByNom(serie);
		if(series == null) {
			return ResponseEntity.badRequest().body("La série " + serie + " n'existe pas");
		}else {
			return ResponseEntity.badRequest().body("La série " + serie + " existe");
		}
	}*/
	
	
	
	
	
	
}
