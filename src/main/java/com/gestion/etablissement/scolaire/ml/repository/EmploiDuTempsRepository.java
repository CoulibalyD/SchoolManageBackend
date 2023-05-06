package com.gestion.etablissement.scolaire.ml.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Cours;
import com.gestion.etablissement.scolaire.ml.entity.EmploiDuTemps;

public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, Long> {

	Optional<List<EmploiDuTemps>> findEmploiDuTempsByLibelle(String libelle);

	Optional<List<EmploiDuTemps>> findEmploiDuTempsByCours(Cours cours);

}
