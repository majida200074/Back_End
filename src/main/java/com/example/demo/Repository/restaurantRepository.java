package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.example.demo.Entity.Restaurant;
import com.example.demo.Entity.Serie;
import com.example.demo.Entity.Specialite;
import com.example.demo.Entity.Ville;
import com.example.demo.Entity.Zone;

public interface restaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	List<Restaurant> findByZone(Zone zone);
	List<Restaurant> findBySerie(String serie);
	List<Restaurant> findByZoneAndSpecialite(Zone zone,Specialite specialite);
	
    List<Restaurant> findByZoneAndSerie(Zone zone, Serie serie);
    Restaurant findById(int id);
    
    //ResponseEntity<?> getRestaurantitineraire(String ville,String zone, int id);
    

	
    
}
