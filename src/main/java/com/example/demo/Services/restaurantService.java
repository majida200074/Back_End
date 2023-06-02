package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.IDao;
import com.example.demo.Entity.Restaurant;
import com.example.demo.Entity.Serie;
import com.example.demo.Entity.Specialite;
import com.example.demo.Entity.Zone;
import com.example.demo.Repository.restaurantRepository;
import com.example.demo.Repository.serieRepository;
import com.example.demo.Repository.specialiteRepository;
import com.example.demo.Repository.zoneRepository;

@Service
public class restaurantService implements IDao<Restaurant> {
	
	@Autowired
	private restaurantRepository restaurantrepository;
	@Autowired 
	private zoneRepository zonerepository;
	@Autowired
	private specialiteRepository specialiterepository;
	@Autowired 
	private serieRepository serierepository;
	
	
	public List<Restaurant> findByZone(String ville, String zone){
		Zone nom = zonerepository.findByNomAndVilleNom(zone,ville);
        return restaurantrepository.findByZone(nom);
	}
	
	public List<Restaurant> findBySpecialite(String ville,String zone, String specialite){
		Zone nomzone = zonerepository.findByNomAndVilleNom(zone, ville);
		 Specialite nomspecialite = specialiterepository.findByNom(specialite);
		 return restaurantrepository.findByZoneAndSpecialite(nomzone,nomspecialite);
	}
	public List<Restaurant> findBySerie(String ville, String zone, String serie){
		Zone nomzone = zonerepository.findByNomAndVilleNom(zone, ville);
		 Serie nomserie = serierepository.findByNom(serie);
		 return restaurantrepository.findByZoneAndSerie(nomzone, nomserie);
	}
	public Restaurant findInformations(String ville, String zone, int id) {
		Zone nomzone = zonerepository.findByNomAndVilleNom(zone, ville);
		 return restaurantrepository.findById(id);
	}
	
	@Override
	public Restaurant findById(int id) {
		return restaurantrepository.findById(id);
	}

	@Override
	public List<Restaurant> findAll() {
		return restaurantrepository.findAll();
	}

	@Override
	public Restaurant update(int id, Restaurant o) {
		Restaurant restaurant = restaurantrepository.findById(id);
		restaurant.setAdresse(o.getAdresse());
		restaurant.setClose(o.getClose());
		restaurant.setLattitude(o.getLattitude());
		restaurant.setLongtitude(o.getLongtitude());
		restaurant.setNom(o.getNom());
		restaurant.setOpen(o.getOpen());
		restaurant.setRank(o.getRank());
		restaurant.setWeekend(o.getWeekend());
		restaurant.setSerie(o.getSerie());
		restaurant.setUser(o.getUser());
		restaurant.setZone(o.getZone());
		return restaurantrepository.save(restaurant);
	}

	@Override
	public void delete(int id) {
		Restaurant restaurant = restaurantrepository.findById(id);
		restaurantrepository.delete(restaurant);
	}

	@Override
	public Restaurant save(Restaurant o) {
		return restaurantrepository.save(o);
	}

}
