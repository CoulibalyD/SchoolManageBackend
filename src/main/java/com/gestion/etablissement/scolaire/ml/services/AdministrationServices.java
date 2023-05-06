package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Administration;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.AdministrationRepository;

@Service
public class AdministrationServices {
	@Autowired
	private AdministrationRepository administrationRepository;
	public Administration saveAdministration(Administration admin) {
		return administrationRepository.save(admin);
	}
	public Administration updateAdministration(Administration admin) {
		return administrationRepository.saveAndFlush(admin);
	}
	public List<Administration> getAllAdministration(Long id){
		return administrationRepository.findAll();
	}
	public Administration getAdministrationById(Long id) {
		return administrationRepository.findAdministrationById(id).orElseThrow(() -> new UserNotFoundException("Cette personne d'identifiant :" + id+ "n'existe pas sorry!!!"));
	}
	public Administration getAdministrationByTypeUsers(String type) {
		return administrationRepository.findAdministrationByTypeUsers(type).orElseThrow(() -> new UserNotFoundException("Cet Utilisateur de Type : " + type + "n'existe pas sorry !!!"));
	}
	public void deleteAdministration(Administration admin) {
		administrationRepository.delete(admin);
	}
	public void deleteAdministrationById(Long id) {
		administrationRepository.deleteById(id);
	}
}
