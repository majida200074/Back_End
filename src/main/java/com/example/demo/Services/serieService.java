package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.IDao;
import com.example.demo.Entity.Serie;
import com.example.demo.Repository.serieRepository;

@Service
public class serieService implements IDao<Serie>{

	@Autowired
	serieRepository serierepository;
	
	@Override
	public Serie findById(int id) {
		return serierepository.findById(id);
	}

	@Override
	public List<Serie> findAll() {
		return serierepository.findAll();
	}

	@Override
	public Serie update(int id, Serie o) {
		Serie series = serierepository.findById(id);
		series.setNom(o.getNom());
		return serierepository.save(series);
	}

	@Override
	public void delete(int id) {
		Serie series = serierepository.findById(id);
		serierepository.delete(series);
	}

	@Override
	public Serie save(Serie o) {
		return serierepository.save(o);
	}
	
}
