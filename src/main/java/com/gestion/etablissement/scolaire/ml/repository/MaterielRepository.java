package com.gestion.etablissement.scolaire.ml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel,Long> {

	Optional<Materiel> findMaterielById(Long id);

	Optional<Materiel> findMaterielByDesignation(String designantion);

}
