package com.gestion.etablissement.scolaire.ml.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Cours")
public class Cours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Coefficient")
	private Double coefficient;
	@Column(name = "Libelle")
	private String libelle;
	@Column(name = "Description")
	private String description;
	
	public Cours(Double coefficient, String libelle, String description) {
		this.coefficient = coefficient;
		this.libelle = libelle;
		this.description = description;
	}

	public Cours(Long id, Double coefficient, String libelle, String description) {
		this(coefficient,libelle,description);
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
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
		return "Cours [id=" + id + ", coefficient=" + coefficient + ", libelle=" + libelle + ", description="
				+ description + "]";
	}
	public  void presenteCours() {
		System.out.println(toString());
	}
}
