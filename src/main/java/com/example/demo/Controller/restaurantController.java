package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Entity.Restaurant;

import com.example.demo.Services.restaurantService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("restaurants")
public class restaurantController {

	@Autowired
	private restaurantService restaurantservice;
	
	
	// Récupérer la liste des restaurants pour une zone donnée
	 @GetMapping("/villes/{ville}/zones/{zone}/restaurants")
	    public List<Restaurant> findByZone(@PathVariable String ville, @PathVariable String zone) {
	        return restaurantservice.findByZone(ville, zone);
	    }
	 
	 //Filtrer la liste des restaurants par spécialité
	 @GetMapping("/villes/{ville}/zones/{zone}/restaurants/specialites/{specialite}")
	 public List<Restaurant> findBySpecialite(@PathVariable String ville, @PathVariable String zone, @PathVariable String specialite){
		 return restaurantservice.findBySpecialite(ville, zone, specialite);
	 }
	 
	 //Filtrer la liste des restaurants par chaîne
	 //?serie=
	 @GetMapping("/villes/{ville}/zones/{zone}/restaurants/series/{serie}")
	 public List<Restaurant> findBySerie(@PathVariable String ville, @PathVariable String zone, @PathVariable String serie){
		 return restaurantservice.findBySerie(ville, zone, serie);
	 }
	 
    // Récupérer les informations d’un restaurant spécifique
	 @GetMapping("/villes/{ville}/zones/{zone}/restaurants/{id}")
	 public Restaurant findInformations(@PathVariable String ville, @PathVariable String zone, @PathVariable int id){
		 return restaurantservice.findInformations(ville, zone, id);
	 }
	 
	 //Récupérer l’itinéraire pour rejoindre un restaurant
	
	 /*@GetMapping("/villes/{ville}/zones/{zone}/restaurants/{id}/itineraire")
	 public ResponseEntity<?> getRestaurantitineraire(String ville, String zone, int id) {
	        try {

	            Restaurant restaurant = restaurantrepository.findById(id);
	            double endlong = Double.parseDouble(restaurant.getLongtitude());
	            double endlat = Double.parseDouble(restaurant.getLattitude());
	            double [] position = {31.6260606,-7.9929946,endlong,endlat};
	            String jsonData = DemoApplication.apiService.getJsonDataFromApi(position);
	            return new ResponseEntity<>(jsonData,HttpStatus.OK);
	        }catch (Exception ex){
	            ex.printStackTrace();
	        }
	        return  new ResponseEntity<>(new Restaurant(),HttpStatus.BAD_REQUEST);
	    }*/
	 
	 /*@GetMapping("/{ville}/zones/{zone}/restaurants/{id}/itineraire")
	    public ResponseEntity<?> findItineraire(@PathVariable String ville, @PathVariable String zone, @PathVariable int id, @RequestParam double lat, @RequestParam double lon) {
	        Optional<Restaurant> restaurant = Optional.of(restaurantrepository.findById(id));
	        if (restaurant.isPresent()) {
	            String itineraire = "Itineraire de " + lat + "," + lon + " à " + restaurant.get().getLattitude() + "," + restaurant.get().getLongtitude();
	            // appeler ici le service MapBox pour récupérer l'itinéraire
	            return ResponseEntity.ok(itineraire);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }*/
	 
	 @GetMapping("/api/restaurants")
		public List<Restaurant> findAll(){
			return restaurantservice.findAll();
		}
	 @PostMapping("/save")
		public Restaurant save(@RequestBody Restaurant restaurant){
			return restaurantservice.save(restaurant);
		}
	 @DeleteMapping("/delete/{id}")
		public void delete(@PathVariable (required = true) int id){
		//Ville ville = villeservice.findById(Integer.parseInt(id));
		 	restaurantservice.delete(id);
		}
	 
	 @GetMapping("/findById/{id}")
		public Restaurant findById(@PathVariable int id) {
			return restaurantservice.findById(id);
		}
	 @PutMapping("/update/{id}")
		public Restaurant update(@PathVariable int id,@RequestBody Restaurant restaurant) {
			Restaurant restaurants = restaurantservice.findById(id);
			if(restaurants != null) {
				restaurants.setAdresse(restaurant.getAdresse());
				restaurants.setClose(restaurant.getClose());
				restaurants.setLattitude(restaurant.getLattitude());
				restaurants.setLongtitude(restaurant.getLongtitude());
				restaurants.setNom(restaurant.getNom());
				restaurants.setOpen(restaurant.getOpen());
				restaurants.setRank(restaurant.getRank());
				restaurants.setWeekend(restaurant.getWeekend());
				restaurants.setSerie(restaurant.getSerie());
				restaurants.setUser(restaurant.getUser());
				restaurants.setZone(restaurant.getZone());
				return restaurantservice.save(restaurants);
			}
			return null;
		}
	 
}

