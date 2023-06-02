package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.IDao;
import com.example.demo.Entity.Ville;
import com.example.demo.Entity.Zone;
import com.example.demo.Repository.villeRepository;
import com.example.demo.Repository.zoneRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;


@Service
public class zoneService implements IDao<Zone>{
	
	@Autowired
	private zoneRepository zonerepository;
	@Autowired 
	private villeRepository villerepository;

	public List<Zone> findByVille(String ville){
		Ville villes = villerepository.findByNom(ville);
		return zonerepository.findByVille(villes);
	}
	@Override
	public Zone findById(int id) {
		return zonerepository.findById(id);
	}

	@Override
	public List<Zone> findAll() {
		return zonerepository.findAll();
	}

	@Override
	public Zone update(int id,Zone o) {
		Zone zone = zonerepository.findById(id);
		zone.setNom(o.getNom());
		zone.setVille(o.getVille());
		return zonerepository.save(zone);
	}

	@Override
	public void delete(int id) {
		Zone zone = zonerepository.findById(id);
		zonerepository.delete(zone);
	}

	@Override
	public Zone save(Zone o) {
		return zonerepository.save(o);
	}
	
}
