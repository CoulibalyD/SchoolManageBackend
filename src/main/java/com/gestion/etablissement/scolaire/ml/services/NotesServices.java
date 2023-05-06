package com.gestion.etablissement.scolaire.ml.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.Notes;
import com.gestion.etablissement.scolaire.ml.repository.NoteRepository;

@Service
public class NotesServices {
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private EtudiantsServices etudiantsServices;
	public Notes saveNotes(Notes notes) {
		return noteRepository.save(notes);
	}
	public Notes updateNotes(Notes notes) {
		return noteRepository.saveAndFlush(notes);
	}
	public void deleteNotes(Notes notes) {
		noteRepository.delete(notes);
	}
	public void deleteNotesById(Long id) {
		noteRepository.deleteById(id);
	}
	public List<Notes>	getAllNotes(){
		return noteRepository.findAll();
	}
	public Notes saveNoteByClasseEtudiant(Notes note,Etudiant etudiant) {
		if(etudiantsServices.getEtudiantByNumeroMatricule(etudiant.getNumeroMatricule()).getNumeroMatricule().compareTo(note.getEtudiant().getNumeroMatricule()) == 0) {
			note.setEtudiant(etudiant);
			return noteRepository.save(note);
		}
		return null;
	}
	
	public List<Notes> getAllNoteEtudiant(Etudiant etudiant){
		return noteRepository.findNotesByEtudiant(etudiant).get();//.orElseThrow(() -> new UserNotFoundException("Cet Etudiant de matricule :" + etudiant.getNumeroMatricule()+"n'existe pas sorry!!!"));
	}
		
//	public Notes getNotesByLibelle(String libelle) {
//		return noteRepository.findNotesByLibelle(libelle).orElseThrow(() -> new UserNotFoundException("Cette Note n'existe pas sorry!!!!"));
//	}
}
