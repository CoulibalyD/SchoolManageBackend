package com.gestion.etablissement.scolaire.ml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Cours;

public interface CoursRepository extends JpaRepository<Cours,Long> {

	Optional<Cours> findCoursById(Long id);

	Optional<Cours> findCoursByDescription(String description);

}
