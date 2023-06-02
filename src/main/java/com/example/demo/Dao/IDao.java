package com.example.demo.Dao;

import java.util.List;

public interface IDao<T> {
	T findById(int id);
	List<T> findAll();
	T update(int id,T o);
	void delete(int id);
	T save(T o);
}
