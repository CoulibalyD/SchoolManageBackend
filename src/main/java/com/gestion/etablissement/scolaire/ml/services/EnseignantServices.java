package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Enseignant;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.EnseignantRepository;

@Service
public class EnseignantServices {
	@Autowired
	private EnseignantRepository enseignantRepository;
	public Enseignant saveEnseignant(Enseignant enseignant) {
		return enseignantRepository.save(enseignant);
	}
	public Enseignant updateEnseignant(Enseignant enseignant) {
		return enseignantRepository.saveAndFlush(enseignant);
	}
	public List<Enseignant> getAllEnseignant(){
		return enseignantRepository.findAll();
	}
	public Enseignant getEnseignantById(Long id) {
		return enseignantRepository.findEnseignantById(id).orElseThrow(() -> new UserNotFoundException("Cet Enseignant d'identifiant :" + id+ "n'existe pas sorry"));
	}
	public Enseignant getEnseignantByMatricule(String matricule) {
		return enseignantRepository.findEnseignantByMatricule(matricule).orElseThrow(() -> new UserNotFoundException("Cet Enseignant de matricule :" + matricule+ "n'existe pas sorry"));
	}
}
