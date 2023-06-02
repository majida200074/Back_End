package com.example.demo.Entity;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String Lattitude;
	private String Longtitude;
	private LocalTime open;

	private LocalTime close;
	private String adresse;
	private String weekend;
	private int rank;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "restaurant_specialite",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "specialite_id"))
	@JsonIgnore
	private List<Specialite> specialite;
	
	@JsonIgnore
	@OneToOne
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name = "zone_id")
	@JsonIgnore
	private Zone zone;
	
	@JsonIgnore
	@ManyToOne
	private Serie serie;
	
	@OneToOne(mappedBy="restaurant")
	private Photo photo;
	
	public Restaurant() {}

	
	
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", nom=" + nom + ", Lattitude=" + Lattitude + ", Longtitude=" + Longtitude
				+ ", open=" + open + ", close=" + close + ", adresse=" + adresse + ", weekend=" + weekend + ", rank="
				+ rank + ", specialite=" + specialite + ", user=" + user + ", zone=" + zone + ", serie=" + serie
				+ ", photo=" + photo + "]";
	}



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

	public String getLattitude() {
		return Lattitude;
	}

	public void setLattitude(String lattitude) {
		Lattitude = lattitude;
	}

	public String getLongtitude() {
		return Longtitude;
	}

	public void setLongtitude(String longtitude) {
		Longtitude = longtitude;
	}

	public LocalTime getOpen() {
		return open;
	}

	public void setOpen(LocalTime open) {
		this.open = open;
	}

	public LocalTime getClose() {
		return close;
	}

	public void setClose(LocalTime close) {
		this.close = close;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getWeekend() {
		return weekend;
	}

	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public List<Specialite> getSpecialite() {
		return specialite;
	}

	public void setSpecialite(List<Specialite> specialite) {
		this.specialite = specialite;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	
}
