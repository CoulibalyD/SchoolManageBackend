package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Livres")
public class Livres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Nom")
	private String nom;
	@Column(name = "NomAuteur")
	private String nomAuteur;
	@Column(name = "Designation")
	private String designation;
	@Column(name = "DateEmpreinte")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEmpreinte;
	@Column(name = "DateRendu")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateRendu;
	@Column(name = "Edition")
	private String edition;
	@Column(name = "Empreinte")
	private Empreinte empreinte;
	@Column(name = "PrixEmpreinte")
	private Double prixEmpreinte;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNomAuteur() {
		return nomAuteur;
	}
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
	
	public Date getDateEmpreinte() {
		return dateEmpreinte;
	}
	public void setDateEmpreinte(Date dateEmpreinte) {
		this.dateEmpreinte = dateEmpreinte;
	}
	public Date getDateRendu() {
		return dateRendu;
	}
	public void setDateRendu(Date dateRendu) {
		this.dateRendu = dateRendu;
	}
	public void setEmpreinte(Empreinte empreinte) {
		this.empreinte = empreinte;
	}
	public Date getDate() {
		return dateEmpreinte;
	}
	public void setDate(Date date) {
		this.dateEmpreinte = date;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Empreinte getEmpreinte() {
		return empreinte;
	}
	public void setEmpreinte(String empreinte) {
		this.empreinte =Empreinte.valueOf(empreinte);
	}
	public Double getPrixEmpreinte() {
		return prixEmpreinte;
	}
	
	public Livres(String nom, String nomAuteur, String designation, Date dateEmpreinte, Date dateRendu, String edition,
			Empreinte empreinte, Double prixEmpreinte) {
		this.nom = nom;
		this.nomAuteur = nomAuteur;
		this.designation = designation;
		this.dateEmpreinte = dateEmpreinte;
		this.dateRendu = dateRendu;
		this.edition = edition;
		this.empreinte = empreinte;
		this.prixEmpreinte = prixEmpreinte;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setPrixEmpreinte(Double prixEmpreinte) {
		if(prixEmpreinte > 0)
			this.prixEmpreinte = prixEmpreinte;
	}
}
