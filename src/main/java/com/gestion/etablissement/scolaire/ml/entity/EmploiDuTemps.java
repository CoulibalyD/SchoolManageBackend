package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "T_EmploiDuTemps")
public class EmploiDuTemps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "DateCours")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCours;
	@Column(name = "Libelle")
	private String libelle;
	@Column(name = "HeureCours")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date heureCours;
	@ManyToMany(mappedBy = "libelle",fetch = FetchType.LAZY)
	private Set<Cours> cours = new HashSet<>();
	public EmploiDuTemps(Date dateCours, String libelle, Date heureCours, Set<Cours> cours) {
		this.dateCours = dateCours;
		this.libelle = libelle;
		this.heureCours = heureCours;
		this.cours = cours;
	}
	public Set<Cours> getCours() {
		return cours;
	}
	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateCours() {
		return dateCours;
	}
	public void setDateCours(Date dateCours) {
		this.dateCours = dateCours;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getHeureCours() {
		return heureCours;
	}
	public void setHeureCours(Date heureCours) {
		this.heureCours = heureCours;
	}

//	private Classe classe;
//	private Cours cours;
	
}
