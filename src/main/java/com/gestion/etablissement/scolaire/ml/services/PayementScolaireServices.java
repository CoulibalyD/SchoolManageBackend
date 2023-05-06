package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.PayementScolaire;
import com.gestion.etablissement.scolaire.ml.exception.UserNotFoundException;
import com.gestion.etablissement.scolaire.ml.repository.PayementScolaireRepository;

@Service
public class PayementScolaireServices {
	@Autowired
	private PayementScolaireRepository payementScolaireRepository;
	@Autowired
	private EtudiantsServices etudiantsServices;
	public PayementScolaire savePayementScolaire(PayementScolaire payementScolaire) {
		return payementScolaireRepository.save(payementScolaire);
	}
	public PayementScolaire updatePayementScolaire(PayementScolaire payementScolaire) {
		return payementScolaireRepository.saveAndFlush(payementScolaire);
	}
	public List<PayementScolaire> getAllPayementScolaire(){
		return payementScolaireRepository.findAll();
	}
	public void deletePayementScolaire(PayementScolaire payementScolaire) {
		payementScolaireRepository.delete(payementScolaire);
	}
	public void deletePayementScolaireById(Long id) {
		payementScolaireRepository.deleteById(id);
	}
	public PayementScolaire getPayementScolaireById(Long id) {
		return payementScolaireRepository.findPayementScolaireById(id).orElseThrow(() -> new UserNotFoundException("Cet payement identifiant :" + id+ "n'existe pas sorry!!"));
	}
	public PayementScolaire saveEtudiantPayementScolaires(PayementScolaire payementScolaire,Etudiant etudiant) {
		payementScolaire.setEtudiant(etudiantsServices.getEtudiantByNumeroMatricule(etudiant.getNumeroMatricule()));
		return payementScolaireRepository.saveAndFlush(payementScolaire);
	}
	public List<PayementScolaire> getAllPayementScolaireByEtudiant(Etudiant etudiant){
		return payementScolaireRepository.findPayementScolaireByEtudiant(etudiant).orElseThrow(() ->new UserNotFoundException("Pas de payement pour cet etudiant de numero matricule "+ etudiant.getNumeroMatricule()+ "Sorry!!!"));
	}
	
}
