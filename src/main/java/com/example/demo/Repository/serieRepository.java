package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Serie;

public interface serieRepository extends JpaRepository<Serie,Integer>{
	Serie findById(int id);
	Serie findByNom(String nom);
}
