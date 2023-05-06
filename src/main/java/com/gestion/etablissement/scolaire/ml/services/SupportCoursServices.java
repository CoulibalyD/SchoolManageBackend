package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.SupportCours;
import com.gestion.etablissement.scolaire.ml.repository.SupportCoursRepository;

@Service
public class SupportCoursServices {
	@Autowired
	private SupportCoursRepository supportCoursRepository;
	public SupportCours saveSupportCours(SupportCours supportCours) {
		return supportCoursRepository.save(supportCours);
	}
	public SupportCours updateSupportCours(SupportCours supportCours) {
		return supportCoursRepository.saveAndFlush(supportCours);
	}
	public List<SupportCours> getSupportCours(){
		return supportCoursRepository.findAll();
	}
	public void deleteSupportCours(SupportCours cours) {
		supportCoursRepository.delete(cours);
	}
	public void deleteSupportCoursById(Long id) {
		supportCoursRepository.deleteById(id);
	}
}
