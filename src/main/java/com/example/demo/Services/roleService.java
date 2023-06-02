package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.IDao;
import com.example.demo.Entity.Role;
import com.example.demo.Repository.roleRepository;

@Service
public class roleService implements IDao<Role>{

	@Autowired
	private roleRepository rolerepository;
	
	@Override
	public Role findById(int id) {
		return rolerepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return rolerepository.findAll();
	}

	@Override
	public Role update(int id, Role o) {
		Role role = rolerepository.findById(id);
		role.setLibelle(o.getLibelle());
		return rolerepository.save(role);
	}

	@Override
	public void delete(int id) {
		Role role = rolerepository.findById(id);
		rolerepository.delete(role);
	}

	@Override
	public Role save(Role o) {
		return rolerepository.save(o);
	}

}
