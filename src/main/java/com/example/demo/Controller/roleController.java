package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Role;
import com.example.demo.Services.roleService;

@RestController
@RequestMapping("roles")
public class roleController {
	@Autowired
	private roleService roleservice;
	
	@GetMapping("/api/villes")
	public List<Role> findAll(){
		return roleservice.findAll();
	}
	
	@PostMapping("/save")
	public Role save(@RequestBody Role role){
		return roleservice.save(role);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) int id){
		roleservice.delete(id);
	}
	
	@GetMapping("/findById/{id}")
	public Role findById(@PathVariable int id) {
		return roleservice.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public Role update(@PathVariable int id,@RequestBody Role role) {
		Role roles = roleservice.findById(id);
		if(roles != null) {
			roles.setLibelle(role.getLibelle());
			return roleservice.save(roles);
		}
		return null;
	}
	
	
	
	
	
}
