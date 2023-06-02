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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Ville;
import com.example.demo.Entity.Zone;
import com.example.demo.Services.villeService;
import com.example.demo.Services.zoneService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("zones")
public class zoneController {
	
	@Autowired
	private zoneService zoneservice;
	@Autowired 
	private villeService villeservice;
	
	@GetMapping("/api/zones")
	public List<Zone> findAll(){
		return zoneservice.findAll();
	}
	//Récupération de toutes les zones pour une ville donnée
	@GetMapping("/api/villes/{ville}/zones")
	public List<Zone> findByVilles(@PathVariable String ville){
		return zoneservice.findByVille(ville);
	}
	
	@PostMapping("/save")
	public Zone save(@RequestBody Zone zone){
	    return zoneservice.save(zone);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) int id){
		//Zone zone = zoneservice.findById(Integer.parseInt(id));
		zoneservice.delete(id);
	}
	
	@GetMapping("/findById/{id}")
	public Zone findById(@PathVariable int id) {
		return zoneservice.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public Zone update(@PathVariable int id,@RequestBody Zone zone) {
		return zoneservice.update(id, zone);
	}
	
	
}
