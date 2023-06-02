package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.IDao;
import com.example.demo.Entity.Ville;
import com.example.demo.Repository.villeRepository;

@Service
public class villeService implements IDao<Ville>{
	
	@Autowired 
	private villeRepository villerepository;
	@Override
	public List<Ville> findAll() {
		return villerepository.findAll();
	}
	
	@Override
	public Ville update(int id,Ville o) {
		Ville ville = villerepository.findById(id);
		ville.setNom(o.getNom());
		return villerepository.save(ville);
	}

	@Override
	public void delete(int id) {
		Ville ville = villerepository.findById(id);
		villerepository.delete(ville);
	}

	@Override
	public Ville save(Ville o) {
		return villerepository.save(o);
	}

	@Override
	public Ville findById(int id) {
		return villerepository.findById(id);
	}
	

}
