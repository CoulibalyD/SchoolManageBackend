package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Materiel;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.MaterielRepository;

@Service
public class MaterielServices {
	@Autowired
	private MaterielRepository materielRepository;
	public Materiel saveMateriel(Materiel materiel) {
		return materielRepository.save(materiel);
	}
	public Materiel updateMateriel(Materiel materiel) {
		return materielRepository.saveAndFlush(materiel);
	}
	public void deleteMateriel(Materiel materiel) {
		materielRepository.delete(materiel);
	}
	public void deleteMaterielById(Long id) {
		materielRepository.deleteById(id);
	}
	public List<Materiel> getAllMateriels(){
		return materielRepository.findAll();
	}
	public Materiel getMaterielBy(Long id) {
		return materielRepository.findMaterielById(id).orElseThrow(() -> new UserNotFoundException("Cette Materielle"+ id +"n'existe pas sorry"));
	}
	public Materiel getMaterielByDesignation(String designantion) {
		return materielRepository.findMaterielByDesignation(designantion).orElseThrow(() -> new UserNotFoundException("Cette materielle de designation :"+ designantion+ "n'existe pas sorry!!!"));
	}
}
