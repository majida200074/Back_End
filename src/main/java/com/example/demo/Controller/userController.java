package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Ville;
import com.example.demo.Services.userService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("users")
public class userController {
	
	@Autowired
	private userService userservice;
	
	@GetMapping("/api/users")
	public List<User> findAll(){
		return userservice.findAll();
	}
	
	@PostMapping("/save")
	public User save(@RequestBody User user){
		return userservice.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) int id){
		userservice.delete(id);
	}
	
	@GetMapping("/findById/{id}")
	public User findById(@PathVariable int id) {
		return userservice.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public User update(@PathVariable int id,@RequestBody User user) {
		return userservice.update(id, user);
	}
	
	
	
	
}
