package com.gestion.etablissement.scolaire.ml.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Livres;

public interface LivresRepository extends JpaRepository<Livres,Long> {

	Optional<Livres> findLivresByNom(String nom);

	Optional<Livres> findLivresByDesignation(String designation);

	Optional<List<Livres>> findLivresByEmpreinte(String empreinte);

	Optional<Livres> findLivresByPrixEmpreinte(Double prix);

	Optional<List<Livres>> findAllLivresByNomAuteur(String nomAuteur);

}
