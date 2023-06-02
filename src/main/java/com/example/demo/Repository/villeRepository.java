package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Ville;

public interface villeRepository extends JpaRepository<Ville, Integer>{
	Ville findById(int id);
	
	Ville findByNom(String nom);
}
