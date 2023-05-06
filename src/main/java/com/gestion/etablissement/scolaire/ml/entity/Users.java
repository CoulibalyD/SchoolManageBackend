package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.gestion.etablissement.scolaire.ml.confFile.SecurityConfig;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
@Table(name = "T_utilisateur",uniqueConstraints = {@UniqueConstraint(columnNames = "Matricule"),@UniqueConstraint(columnNames = "telephone"),@UniqueConstraint(columnNames = "imageUsers")
,@UniqueConstraint(columnNames = "Email "),@UniqueConstraint(columnNames = "Password")})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "Nom")
	private String nom;
	@Column(name = "Prenom")
	private String prenom;
	@Column(name = "Adresse")
	private String adresse;
	@Column(name = "Genre")
	private Genre genre;
	@Column(name = "Phone")
	private String telephone;
	@Column(name = "TypeUsers")
	private TypeUsers typeUsers;
	@Column(name = "Matricule")
	private String matricule;
	@Column(name = "Email")
	private String email;
	@Column(name = "Password")
	private String password;
	@Column(name = "DateNaissance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	@Column(name = "Image")
	private String imageUsers;
	@OneToMany(mappedBy = "fonction",fetch = FetchType.LAZY)
	private Set<Profile> profile = new HashSet<>();
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
		this.password = SecurityConfig.crypt(password);
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
	public Users(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers, String matricule,
			String email, String password, Date dateNaissance) {
		this(email,password);
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.typeUsers = typeUsers;
		this.matricule = matricule;
	
		this.dateNaissance = dateNaissance;
	}
	public Users(String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers, String matricule,
			String email, String password, Date dateNaissance, String imageUsers) {
		this(nom,prenom,adresse,telephone,typeUsers,matricule,email,password,dateNaissance);
		this.imageUsers = imageUsers;
	}
	public Users(Long id, String nom, String prenom, String adresse, String telephone, TypeUsers typeUsers,
			String matricule, String email, String password, Date dateNaissance, String imageUsers) {
		this(nom,prenom,adresse,telephone,typeUsers,matricule,email,password,dateNaissance,imageUsers);
		this.id = id;
	}
	public Users() {}
	public Users(String email, String password) {
		this.email = email;
		this.setPassword(password);
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", genre=" + genre
				+ ", telephone=" + telephone + ", typeUsers=" + typeUsers + ", matricule=" + matricule + ", email="
				+ email + ", password=" + password + ", dateNaissance=" + dateNaissance + ", imageUsers=" + imageUsers
				+ "]";
	}
	public void presenterUsers() {
		System.out.println(toString());
	}
}
