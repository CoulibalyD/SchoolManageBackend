package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Administration")
public class Administration extends Users {
	@Column(name = "Diplome")
	private String diplome;
	@Column(name = "Competence")
	private String competence;
	@Column(name = "Experience")
	private String experience; 
	@Column(name = "TypeAdministration")
	private TypeAdministration typeAdministration;
	public Administration() {}
	public Administration(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers,
			String matricule, String email, String password, Date dateNaissance) {
		super(nom, prenom, adresse, telephone, typeUsers, matricule, email, password, dateNaissance);
	}
	
	public Administration(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers,
			String matricule, String email, String password, Date dateNaissance, String diplome, String competence,
			String experience) {
		this(nom,prenom,adresse,telephone,typeUsers,matricule,email,password,dateNaissance);
		this.diplome = diplome;
		this.competence = competence;
		this.experience = experience;
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
	public TypeAdministration getTypeAdministration() {
		return typeAdministration;
	}
	public void setTypeAdministration(TypeAdministration typeAdministration) {
		this.typeAdministration = typeAdministration;
	}
	@Override
	public String toString() {
		return super.getTypeUsers() + "Administration [diplome=" + diplome + ", competence=" + competence + ", experience=" + experience
				+ ", typeAdministration=" + typeAdministration + "]";
	}
	
}
