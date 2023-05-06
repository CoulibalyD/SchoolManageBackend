package com.gestion.etablissement.scolaire.ml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

	Optional<Enseignant> findEnseignantById(Long id);

	Optional<Enseignant> findEnseignantByMatricule(String matricule);

}
