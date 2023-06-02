package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Role;

public interface roleRepository extends JpaRepository<Role,Integer>{
	Role findById(int id);
}
