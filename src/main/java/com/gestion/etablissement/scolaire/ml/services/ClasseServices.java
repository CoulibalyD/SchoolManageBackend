package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Classe;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.ClasseRepository;

@Service
public class ClasseServices {
	@Autowired
	private ClasseRepository classeRepository;
	
	public List<Classe> getAllClasse(){
		return classeRepository.findAll();
	}
	public Classe getClasseByLibelle(String libelle) {
		return classeRepository.findClasseByLibelle(libelle).orElseThrow(() -> new UserNotFoundException("Cette classe Libelle"+ libelle +" n'existe pas sorry!!!!"));
	}
	public Classe saveClasse(Classe classe) {
		return classeRepository.save(classe);
	}
	public Classe updateClasse(Classe classe) {
		return classeRepository.saveAndFlush(classe);
	}
	public void deleteclasse(Classe classe) {
		classeRepository.delete(classe);
	}
	public String deleteClasseByLibelle(String libelle) {
		return classeRepository.deleteClasseByLibelle(libelle).orElseThrow(() -> new UserNotFoundException("Impossible de supprime cette classe libelle"+ libelle + "sorry !!!"));
	}
	public void deleteClasseById(Long id) {
		classeRepository.deleteById(id);
	}
	public List<Classe> getAllClasseAbrege(String abrege){
		return classeRepository.findClasseByAbrege(abrege).orElseThrow(() -> new UserNotFoundException("Cette classe d'abrege :"+ abrege + "n'existe pas sorry!!!"));
	}
}
