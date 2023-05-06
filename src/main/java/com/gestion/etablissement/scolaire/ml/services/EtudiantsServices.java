package com.gestion.etablissement.scolaire.ml.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Classe;
import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.Livres;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.EtudiantRepository;
@Service
public class EtudiantsServices {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ClasseServices classeServices;
//	@Autowired
//	private LivresServices livresServices;
	public  Etudiant saveEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	public Etudiant updateEtudiant(Etudiant etudiant) {
		return etudiantRepository.saveAndFlush(etudiant);
	}
	public List<Etudiant> getAllEtudiant(){
		return etudiantRepository.findAll();
	}
	public Etudiant getEtudiantById(Long id) {
		return etudiantRepository.findEtudiantById(id).orElseThrow(() -> new UserNotFoundException("Cet etudiant n'exist pas sorry!!!"));
	}
	public void deleteEtudiant(Etudiant etudiant) {
		
		etudiantRepository.delete(getEtudiantById(etudiant.getId()));
	}
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
	}
	public Etudiant getEtudiantByNumeroMatricule(String numeroMatricule) {
		return etudiantRepository.findEtudiantByNumeroMatricule(numeroMatricule).orElseThrow(() -> new UserNotFoundException("Cet Etudiant Numero Matricule : " + numeroMatricule + "n'existe pas sorry"));
	}
	public List<Etudiant> getAllEtudiantByClasse(Classe classe){
		return etudiantRepository.findEtudiantByClasse(classe).orElseThrow(() -> new UserNotFoundException("Cette liste des etudiants de la classe :" + classe.getLibelle()+"n'existe pas sorry!!!"));
	}
	public List<Etudiant> getAllEtudiant(String libelle){
		return getAllEtudiantByClasse(classeServices.getClasseByLibelle(libelle));
	}
	public List<Livres> getAllEtudiantLivresEmpreinte(Etudiant etudiant){
		Set<Livres> livres = etudiant.getLivres();
		List<Livres> liv = new ArrayList<>();
		for(Livres livre :livres) {
			if(livre.getEmpreinte().name().compareTo("Empreinte") == 0) {
				liv.add(livre);
			}
		}
		return liv;
	}
	
}

