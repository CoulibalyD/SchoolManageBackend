package com.gestion.etablissement.scolaire.ml.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.Notes;

public interface NoteRepository extends JpaRepository<Notes, Long> {

	Optional<List<Notes>> findNotesByEtudiant(Etudiant etudiant);


	//Optional<Notes> findNotesByLibelle(String libelle);

//	Optional<List<Notes>> findAllNotesEtudiant(Etudiant etudiant);
}
