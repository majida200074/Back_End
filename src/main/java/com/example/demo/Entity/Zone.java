package com.example.demo.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Zone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "villes_id")
	private Ville ville;
	
	@JsonIgnore
	@OneToMany(mappedBy="zone")
	private List<Restaurant> restaurant;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public List<Restaurant> getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}
	@Override
	public String toString() {
		return "Zone [id=" + id + ", nom=" + nom + ", ville=" + ville + ", restaurant=" + restaurant + "]";
	}
	
	
}
