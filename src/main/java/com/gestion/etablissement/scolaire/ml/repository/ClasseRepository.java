package com.gestion.etablissement.scolaire.ml.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Classe;

public interface ClasseRepository extends JpaRepository<Classe,Long> {

	Optional<Classe> findClasseByLibelle(String libelle);

	Optional<String> deleteClasseByLibelle(String libelle);

	Optional<List<Classe>> findClasseByAbrege(String abrege);

}
