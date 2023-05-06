package com.gestion.etablissement.scolaire.ml.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Classe;
import com.gestion.etablissement.scolaire.ml.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {


	Optional<Etudiant> findEtudiantById(Long id);

	Optional<Etudiant> findEtudiantByNumeroMatricule(String numeroMatricule);

	Optional<List<Etudiant>> findEtudiantByClasse(Classe classe);
}
