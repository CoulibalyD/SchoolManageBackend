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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "T_SupportCours")
public class SupportCours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NomCours")
	private String nomCours;
	@Column(name = "DateDepot")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDepot;
	@OneToMany(mappedBy = "libelle", fetch = FetchType.LAZY)
	private Set<Classe> classe = new HashSet<>();
	@Column(name = "FicheDuCours")
	private String ficheDuCours;
	// Les methodes getters et setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomCours() {
		return nomCours;
	}
	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}
	public Date getDateDepot() {
		return dateDepot;
	}
	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public Set<Classe> getClasse() {
		return classe;
	}
	public void setClasse(Set<Classe> classe) {
		this.classe = classe;
	}
	public String getFicheDuCours() {
		return ficheDuCours;
	}
	public void setFicheDuCours(String ficheDuCours) {
		this.ficheDuCours = ficheDuCours;
	}
	//Les constructeurs des la classes 
	public SupportCours() {}
	
	public SupportCours(String nomCours, Date dateDepot, String ficheDuCours) {
		this.nomCours = nomCours;
		this.dateDepot = dateDepot;
		this.ficheDuCours = ficheDuCours;
	}
	public SupportCours(Long id, String nomCours, Date dateDepot, String ficheDuCours) {
		this(nomCours,dateDepot,ficheDuCours);
		this.id = id;
	}
	@Override
	public String toString() {
		return "SupportCours [id=" + id + ", nomCours=" + nomCours + ", dateDepot=" + dateDepot + ", classe=" + classe
				+ ", ficheDuCours=" + ficheDuCours + "]";
	}
}
