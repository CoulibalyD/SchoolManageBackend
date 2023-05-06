package com.gestion.etablissement.scolaire.ml.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Materiel")
public class Materiel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Prix")
	private Double prix;
	@Column(name = "Designation")
	private String designation;
	@Column(name = "Etat")
	private EtatMateriel etatMateriel;
	public Materiel() {super();}
	public Materiel(Double prix, String designation, EtatMateriel etatMateriel) {
		this.setPrix(prix);
		this.designation = designation;
		this.etatMateriel = etatMateriel;
	}
	public Materiel(Long id, Double prix, String designation, EtatMateriel etatMateriel) {
		this(prix,designation,etatMateriel);
		this.id = id;
	} 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		if(prix > 0)
			this.prix = prix;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public EtatMateriel getEtatMateriel() {
		return etatMateriel;
	}
	public void setEtatMateriel(EtatMateriel etatMateriel) {
		this.etatMateriel = etatMateriel;
	}
	@Override
	public String toString() {
		return "Materiel [id=" + id + ", prix=" + prix + ", designation=" + designation + ", etatMateriel="
				+ etatMateriel + "]";
	}
	public void presenterMateriel() {
		System.out.println(toString());
	}
}
