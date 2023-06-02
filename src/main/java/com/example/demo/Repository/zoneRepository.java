package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Ville;
import com.example.demo.Entity.Zone;

public interface zoneRepository extends JpaRepository<Zone,Integer>{
	Zone findById(int id);
	List<Zone> findByVille(Ville ville);
	
	Zone findByNomAndVilleNom(String zone, String ville);
	
}
