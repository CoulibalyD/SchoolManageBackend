package com.gestion.etablissement.scolaire.ml.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Notes")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FirstNote")
	private Double firstNote;
	@Column(name = "SecondNote")
	private Double secondNote;
	@Column(name = "ExamenNote")
	private Double examenNote;
	@ManyToOne
	private Etudiant etudiant;
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Notes(Double firstNote, Double secondNote, Double examenNote) {
		this.firstNote = firstNote;
		this.secondNote = secondNote;
		this.examenNote = examenNote;
	}
	public Notes(Long id, Double firstNote, Double secondNote, Double examenNote) {
		this(firstNote,secondNote,examenNote);
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getFirstNote() {
		return firstNote;
	}
	public void setFirstNote(Double firstNote) {
		this.firstNote = firstNote;
	}
	public Double getSecondNote() {
		return secondNote;
	}
	public void setSecondNote(Double secondNote) {
		this.secondNote = secondNote;
	}
	public Double getExamenNote() {
		return examenNote;
	}
	public void setExamenNote(Double examenNote) {
		this.examenNote = examenNote;
	}
	@Override
	public String toString() {
		return "Notes [id=" + id + ", firstNote=" + firstNote + ", secondNote=" + secondNote + ", examenNote="
				+ examenNote + ", etudiant=" + etudiant + "]";
	}
	
}
