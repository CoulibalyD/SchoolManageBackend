package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class UsersComplet {
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

	private MultipartFile imageUsers;

	public UsersComplet(String email, String password) {
		this.email = email;
		this.password = password;
	}

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

	public MultipartFile getImageUsers() {
		return imageUsers;
	}

	public void setImageUsers(MultipartFile imageUsers) {
		this.imageUsers = imageUsers;
	}
}
