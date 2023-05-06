package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.etablissement.scolaire.ml.entity.EmploiDuTemps;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.EmploiDuTempsRepository;

public class EmploiDuTempsServices {
	@Autowired
	private EmploiDuTempsRepository emploiDuTempsRepository;
	@Autowired
	private CoursServices coursServices;
	public EmploiDuTemps saveEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
		return emploiDuTempsRepository.save(emploiDuTemps);
	}
	public EmploiDuTemps updateEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
		return emploiDuTempsRepository.saveAndFlush(emploiDuTemps);
	}
	public List<EmploiDuTemps> getAllEmploiDuTemps(){
		return emploiDuTempsRepository.findAll();
	}
	public void deleteEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
		emploiDuTempsRepository.delete(emploiDuTemps);
	}
	public void deleteEmploiDuTempsById(Long id) {
		emploiDuTempsRepository.deleteById(id);
	}
	public List<EmploiDuTemps> getEmploiDuTempsByLibelle(String libelle){
		return emploiDuTempsRepository.findEmploiDuTempsByLibelle(libelle).orElseThrow(() ->new UserNotFoundException("Cet emploi du temps de libelle " + libelle+ "n'existe pas sorry!!!"));
	}
	public List<EmploiDuTemps> getEmploiDuTempsByCours(String description){
		return emploiDuTempsRepository.findEmploiDuTempsByCours(coursServices.getCoursByDescription(description)).orElseThrow(() ->new UserNotFoundException("Cet emploi du temps de libelle " + description + "n'existe pas sorry!!!"));
	}
}
