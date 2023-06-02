package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.IDao;
import com.example.demo.Entity.User;
import com.example.demo.Repository.userRepository;

@Service
public class userService implements IDao<User>{

	@Autowired
	private userRepository userrepository;
	
	@Override
	public User findById(int id) {
		return userrepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userrepository.findAll();
	}

	@Override
	public User update(int id, User o) {
		User user = userrepository.findById(id);
		user.setNom(o.getNom());
		user.setPrenom(o.getPrenom());
		user.setEmail(o.getEmail());
		user.setMdp(o.getMdp());
		return userrepository.save(user);
	}

	@Override
	public void delete(int id) {
		User user = userrepository.findById(id);
		userrepository.delete(user);
	}

	@Override
	public User save(User o) {
		return userrepository.save(o);
	}

}
