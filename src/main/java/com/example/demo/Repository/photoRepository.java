package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Photo;


public interface photoRepository extends JpaRepository<Photo,Integer>{
	Photo findById(int id);
}
