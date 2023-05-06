package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

public class AdministrationComplete {
	
	private Long id;

	private String nom;

	private String prenom;

	private String adresse;

	private Genre genre;

	private String telephone;

	private TypeUsers typeUsers;

	private String matricule;

	private String email;

	private String password;

	private Date dateNaissance;

	private String imageUsers;

	private String diplome;

	private String competence;

	private String experience;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public TypeUsers getTypeUsers() {
		return typeUsers;
	}

	public void setTypeUsers(TypeUsers typeUsers) {
		this.typeUsers = typeUsers;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getImageUsers() {
		return imageUsers;
	}

	public void setImageUsers(String imageUsers) {
		this.imageUsers = imageUsers;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getCompetence() {
		return competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
}
