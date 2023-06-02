package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Specialite;

public interface specialiteRepository extends JpaRepository<Specialite, Integer>{
	Specialite findById(int id);
	Specialite findByNom(String nom);
}
