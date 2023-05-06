package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Cours;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.CoursRepository;

@Service
public class CoursServices {
	@Autowired
	private CoursRepository coursRepository;
	
	 Cours saveCours(Cours cours) {
		return coursRepository.save(cours);
	}
	public Cours updateCours(Cours cours) {
		return coursRepository.saveAndFlush(cours);
	}
	
	public List<Cours> getListCours(){
		return coursRepository.findAll();     
	}
	public void deleteCours(Cours cours) {
	coursRepository.delete(cours);
	}
	public void deleteCoursById(Long id) {
		coursRepository.deleteById(id);
	}
	public Cours getCoursById(Long id) {
		return coursRepository.findCoursById(id).orElseThrow(() -> new UserNotFoundException("Cet cours d'identifiant : " + id + "n'existe pas!!!"));
	}
	public Cours getCoursByDescription(String description) {
		return coursRepository.findCoursByDescription(description).orElseThrow(() -> new  UserNotFoundException("Cet cours description :" + description+ "n'existe pas sorry!!!"));
	}
}
