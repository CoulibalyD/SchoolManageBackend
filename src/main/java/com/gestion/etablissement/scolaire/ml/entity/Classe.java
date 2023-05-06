package com.gestion.etablissement.scolaire.ml.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Classe")
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Libelle")
	private String libelle;
	@Column(name = "Description")
	private String description;
	@Column(name = "Abrege")
	private String abrege;
	public Classe(String libelle, String description) {
		this.libelle = libelle;
		this.description = description;
	}
	public Classe(Long id, String libelle, String description) {
		this(libelle,description);
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Classe [id=" + id + ", libelle=" + libelle + ", description=" + description + "]";
	}
	public void presenteClasse() {
		System.out.println(toString());
	}
	
}
