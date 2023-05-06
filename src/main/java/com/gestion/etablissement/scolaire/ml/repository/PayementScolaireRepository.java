package com.gestion.etablissement.scolaire.ml.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.PayementScolaire;

public interface PayementScolaireRepository extends JpaRepository<PayementScolaire, Long> {

	Optional<PayementScolaire> findPayementScolaireById(Long id);

	Optional<List<PayementScolaire>> findPayementScolaireByEtudiant(Etudiant etudiant);
	
}
