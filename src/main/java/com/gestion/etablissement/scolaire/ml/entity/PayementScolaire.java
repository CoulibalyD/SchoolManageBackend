package com.gestion.etablissement.scolaire.ml.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "T_PayementScolaire")
public class PayementScolaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "DatePayement")
	private Date datePayement;
	@Column(name = "Montant")
	private Double montant;
	@Column(name = "Status")
	private PaymentStatus status;
	@OneToOne
	private Etudiant etudiant;
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatePayement() {
		return datePayement;
	}
	public void setDatePayement(Date datePayement) {
		this.datePayement = datePayement;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		if(montant>0)
			this.montant = montant;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PayementScolaire [id=" + id + ", datePayement=" + datePayement + ", montant=" + montant + ", status="
				+ status + "]";
	}
	public void presenterPayementScolaire() {
		System.out.println(toString());
	}
}
