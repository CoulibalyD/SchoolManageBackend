package com.gestion.etablissement.scolaire.ml.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gestion.etablissement.scolaire.ml.confFile.ConfigurationFileDataBase;
import com.gestion.etablissement.scolaire.ml.entity.Administration;
import com.gestion.etablissement.scolaire.ml.entity.AdministrationComplete;
import com.gestion.etablissement.scolaire.ml.entity.Etudiant;
import com.gestion.etablissement.scolaire.ml.entity.Livres;
import com.gestion.etablissement.scolaire.ml.entity.Materiel;
import com.gestion.etablissement.scolaire.ml.entity.Notes;
import com.gestion.etablissement.scolaire.ml.entity.PayementScolaire;
import com.gestion.etablissement.scolaire.ml.entity.Users;
import com.gestion.etablissement.scolaire.ml.services.AdministrationServices;
import com.gestion.etablissement.scolaire.ml.services.EtudiantsServices;
import com.gestion.etablissement.scolaire.ml.services.LivresServices;
import com.gestion.etablissement.scolaire.ml.services.MaterielServices;
import com.gestion.etablissement.scolaire.ml.services.NotesServices;
import com.gestion.etablissement.scolaire.ml.services.PayementScolaireServices;
import com.gestion.etablissement.scolaire.ml.services.UsersServices;
@org.springframework.stereotype.Controller
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/SchoolManagement")
public class Controller {
	@Autowired
	private EtudiantsServices etudiantsServices;
	@Autowired
	private UsersServices usersServices;
	@Autowired
	private AdministrationServices administrationServices;
	@Autowired
	private MaterielServices materielServices;
	@Autowired
	private NotesServices notesServices;
	@Autowired
	private LivresServices livresServices;
	@Autowired
	private PayementScolaireServices payementScolaireServices;
	
	private Users usersConnecte;
	public Users getUsersConnecte() {
		return usersConnecte;
	}
	public void setUsersConnecte(Users usersConnecte) {
		this.usersConnecte = usersConnecte;
	}
	/*************************************Gestion des Users************************************************************/
	@PostMapping(path = "/creationDBUsers/{File}", consumes = {"multipart/form-data"})
	public ResponseEntity<?> createDataBasesUsers(@RequestParam("File") MultipartFile file){
		if(ConfigurationFileDataBase.isExcelFile(file)) {
			try {
				ConfigurationFileDataBase.createDataBaseUsers(file.getInputStream());
				return ResponseEntity.ok(Map.of("Message","La base est cree avec success"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.badRequest().body("Mauvais requeste la base n'est pas creer sorrry!!!");
	}
	@PostMapping("/saveUsers")//, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Users> ajouterUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(usersServices.saveUserss(users),HttpStatus.CREATED);
	}
	@PutMapping("/updateUsers")
	public ResponseEntity<Users> updateUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(usersServices.updateUsers(users),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<List<Users>>(usersServices.getAllUsers(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteUsers")
	public ResponseEntity<?> deleteUsers(@RequestBody Users users){
		usersServices.deleteUsers(users);
		return ResponseEntity.ok(Map.of("Message","Cet utilisateur a ete supprime avec  success!!!"));
	}
	@DeleteMapping("/deleteUsersById/{Id}")
	public ResponseEntity<HttpStatus> deleteUsersById(@PathVariable("Id") Long id){
		usersServices.deleteUsersById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	/*************************************Gestion des Etudiants************************************************************/
	@PostMapping("/saveEtudiant")
	public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantsServices.saveEtudiant(etudiant),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateEtudiant")
	public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantsServices.updateEtudiant(etudiant),HttpStatus.OK);
	}
	@GetMapping("/getEtudiantById/{Id}")
	public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("Id") Long id){
		return new ResponseEntity<Etudiant>(etudiantsServices.getEtudiantById(id),HttpStatus.OK); 
	}
	@GetMapping("/getEtudiantByNumeroMatricule/{Numero}")
	public ResponseEntity<Etudiant> getEtudiantByNumeroMatricule(@PathVariable("Numero") String numero){
		return new ResponseEntity<Etudiant>(etudiantsServices.getEtudiantByNumeroMatricule(numero),HttpStatus.OK); 
	}
	@GetMapping("/getAllEtudiant")
	public ResponseEntity<List<Etudiant>> getAllEtudiant(){
		return new ResponseEntity<List<Etudiant>>(etudiantsServices.getAllEtudiant(),HttpStatus.OK);
	}
 	@DeleteMapping("/deleteEtudiant")
	public ResponseEntity<?> deleteEtudiant(@RequestBody Etudiant etudiant){
		etudiantsServices.deleteEtudiant(etudiant);
		return ResponseEntity.ok(Map.of("Message","Etudiant supprime avec success..."));
	}
	@DeleteMapping("/deleteEtudiantByid/{Id}")
	public ResponseEntity<?> deleteEtudiant(@PathVariable("Id") Long id){
		etudiantsServices.deleteEtudiantById(id);
		return ResponseEntity.ok(Map.of("Message","Etudiant supprimer avec success..."));
	}
	@GetMapping("/getAllNotesEtudiants")
	public ResponseEntity<List<Notes>> getAllNotesEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<List<Notes>>(notesServices.getAllNoteEtudiant(etudiant),HttpStatus.OK);
	}
	/*************************************Gestion des Administrations************************************************************/
	@PostMapping("/saveAdministration")
	public ResponseEntity<Administration> ajouterAdministration(@RequestBody AdministrationComplete administrationComplete){
		Administration admin = new Administration();
		return new ResponseEntity<Administration>(administrationServices.saveAdministration(admin),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateAdministration")
	public ResponseEntity<Administration> updateAdministration(@RequestBody Administration admin){
		return new ResponseEntity<Administration>(administrationServices.updateAdministration(admin),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAdministrationByType/{Type}")
	public ResponseEntity<Administration> getAdministrationByTypeUser(@PathVariable("Type") String type){
		return new ResponseEntity<Administration>(administrationServices.getAdministrationByTypeUsers(type),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteAdministration")
	public ResponseEntity<?> deleteAdministration(@RequestBody Administration administration){
		administrationServices.deleteAdministration(administration);
		return ResponseEntity.ok(Map.of("Message","Administration supprime avec success!!!"));
	}
	@DeleteMapping("/deleteAdministrationById/{Id}")
	public ResponseEntity<?> deleteAdministrationById(@PathVariable("Id") Long id){
		administrationServices.deleteAdministrationById(id);
		return ResponseEntity.ok(Map.of("Message","Administration supprime avec success!!!"));
	}
	/*************************************Gestion des Materielles************************************************************/
	@PostMapping("/saveMaterielle")
	public ResponseEntity<Materiel> ajouterMaterielle(@RequestBody Materiel materiel){
		return new ResponseEntity<Materiel>(materielServices.saveMateriel(materiel),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateMaterielle")
	public ResponseEntity<Materiel> updateMaterielle(@RequestBody Materiel materiel){
		return new ResponseEntity<Materiel>(materielServices.updateMateriel(materiel),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getMaterielleByDesignation/{Designation}")
	public ResponseEntity<Materiel> getMaterielByDesignation(@PathVariable("Designation") String designation){
		return new ResponseEntity<Materiel>(materielServices.getMaterielByDesignation(designation),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getMaterielleById/{Id}")
	public ResponseEntity<Materiel> getMaterielById(@PathVariable("Id") Long id){
		return new ResponseEntity<Materiel>(materielServices.getMaterielBy(id),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllMaterielle")
	public ResponseEntity<List<Materiel>> getAllMateriel(){
		return new ResponseEntity<List<Materiel>>(materielServices.getAllMateriels(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteMarielle")
	public ResponseEntity<?> deleteMateriel(@RequestBody Materiel materiel){
		materielServices.deleteMateriel(materiel);
		return ResponseEntity.ok(Map.of("Message","La materielle est supprimer avec success!!!"));
	}
	@DeleteMapping("/deleteMarielleById/{Id}")
	public ResponseEntity<?> deleteMaterielById(@PathVariable("Id") Long id){
		materielServices.deleteMaterielById(id);
		return ResponseEntity.ok(Map.of("Message","La materielle a ete bien suppprimer avec success!!!"));
	}
	/*************************************Gestion de la biblotheque************************************************************/
	@GetMapping("/getAllLivres")
	public ResponseEntity<List<Livres>> getAllLivres(){
		return new ResponseEntity<List<Livres>>(livresServices.getAllLivres(),HttpStatus.OK);
	}
	@PostMapping("/saveLivres")
	public ResponseEntity<Livres> ajouterLivres(@RequestBody Livres liv){
		return new ResponseEntity<Livres>(livresServices.saveLivres(liv),HttpStatus.CREATED);
	}
	@PutMapping("/updateLivres")
	public ResponseEntity<Livres> updateLivres(@RequestBody Livres liv){
		return new ResponseEntity<Livres>(livresServices.updatelivres(liv),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteLivresById/{Id}")
	public ResponseEntity<?> deleteLivresById(@PathVariable("Id") Long id){
		livresServices.deleteLivresById(id);
		return ResponseEntity.ok(Map.of("Message","Livre a ete supprimer avec success!!!"));
	}
	@DeleteMapping("/deleteLivres")
	public ResponseEntity<?> deleteLivres(@RequestBody Livres livres){
		livresServices.deleteLivres(livres);
		return ResponseEntity.ok(Map.of("Message","Livre a ete supprimer avec success!!!"));
	}
	@GetMapping("/getLivresByNom/{Nom}")
	public ResponseEntity<Livres> getLivresByNom(@PathVariable("Nom") String nom) {
		return new ResponseEntity<Livres>(livresServices.getLivresByNom(nom),HttpStatus.OK);
	}
	@GetMapping("/getLivresByDesignation/{Designation}")
	public ResponseEntity<Livres> getLivresByDesignation(@PathVariable("Designation") String designation) {
		return new ResponseEntity<Livres>(livresServices.getLivresByDesignation(designation),HttpStatus.OK);
	}
	@GetMapping("/getLivresByNomAuteur/{NomAuteur}")
	public ResponseEntity<List<Livres>> getLivresByNomAuteur(@PathVariable("NomAuteur") String nomAuteur) {
		return new ResponseEntity<List<Livres>>(livresServices.getAllLivresByNomAuteur(nomAuteur),HttpStatus.OK);
	}
	/*************************************Gestion de la Notes************************************************************/
	@PostMapping("/saveNotes")
	public ResponseEntity<Notes> ajouterNotes(@RequestBody Notes notes){
		return new ResponseEntity<Notes>(notesServices.saveNotes(notes),HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateNotes")
	public ResponseEntity<Notes> updateNotes(@RequestBody Notes notes){
		return new ResponseEntity<Notes>(notesServices.updateNotes(notes),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteNotes")
	public ResponseEntity<?> deleteNotes(@RequestBody Notes notes){
		notesServices.deleteNotes(notes);
		return ResponseEntity.ok(Map.of("Message ","Notes Supprime avec success!!!"));
	}
	@DeleteMapping("/deleteNotesById/{Id}")
	public ResponseEntity<?> deleteNotesById(@PathVariable("Id") Long id){
		notesServices.deleteNotesById(id);
		return ResponseEntity.ok(Map.of("Message","Note supprime avec success!!!!"));
	}
	/*************************************Gestion de Payement de Scolarites************************************************************/
	@PostMapping("/savePayementScolaire")
	public ResponseEntity<PayementScolaire> createPayementScolaire(@RequestBody PayementScolaire payementScolaire){
		return new ResponseEntity<PayementScolaire>(payementScolaireServices.savePayementScolaire(payementScolaire),HttpStatus.CREATED);
	}
	@PutMapping("/updatePayementScolaire")
	public ResponseEntity<PayementScolaire> updatePayementScolaire(@RequestBody PayementScolaire payementScolaire){
		return new ResponseEntity<PayementScolaire>(payementScolaireServices.updatePayementScolaire(payementScolaire),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllPayementScolaire")
	public ResponseEntity<List<PayementScolaire>> getAllPayementScolaire(){
		return new ResponseEntity<List<PayementScolaire>>(payementScolaireServices.getAllPayementScolaire(),HttpStatus.OK);
	}
	@DeleteMapping("/deletePayementScolaire")
	public ResponseEntity<?> deletePayementScolaire(@RequestBody PayementScolaire payementScolaire){
		payementScolaireServices.deletePayementScolaire(payementScolaire);
		return ResponseEntity.ok(Map.of("Message","Payement scolaire supprime avec success!!!"));
	}
	@DeleteMapping("/deletePayementScolaireById/{Id}")
	public ResponseEntity<?> deletePayementScolaireById(@PathVariable("Id") Long id){
		payementScolaireServices.deletePayementScolaireById(id);
		return ResponseEntity.ok(Map.of("Message","Payement Scolaire supprime avec success!!!"));
	}
	@GetMapping("/getAllPayementScolaireByEtudiant")
	public ResponseEntity<List<PayementScolaire>> getAllPayementScolaireEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<List<PayementScolaire>>(payementScolaireServices.getAllPayementScolaireByEtudiant(etudiant),HttpStatus.OK);
	}
}
