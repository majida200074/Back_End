package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.IDao;
import com.example.demo.Entity.Specialite;
import com.example.demo.Repository.specialiteRepository;

@Service
public class specialiteService implements IDao<Specialite> {

	@Autowired
	private specialiteRepository specialitereposiroty;
	
	@Override
	public Specialite findById(int id) {
		return specialitereposiroty.findById(id);
	}

	@Override
	public List<Specialite> findAll() {
		return specialitereposiroty.findAll();
	}

	@Override
	public Specialite update(int id, Specialite o) {
		Specialite specialites = specialitereposiroty.findById(id);
		specialites.setNom(o.getNom());
		return specialitereposiroty.save(specialites);
	}

	@Override
	public void delete(int id) {
		Specialite specialties = specialitereposiroty.findById(id);
		specialitereposiroty.delete(specialties);
	}

	@Override
	public Specialite save(Specialite o) {
		return specialitereposiroty.save(o);
	}
	
}
