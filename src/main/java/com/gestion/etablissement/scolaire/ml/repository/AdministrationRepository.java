package com.gestion.etablissement.scolaire.ml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Administration;

public interface AdministrationRepository extends JpaRepository<Administration, Long> {

	Optional<Administration> findAdministrationById(Long id);

	Optional<Administration> findAdministrationByTypeUsers(String type);

}
