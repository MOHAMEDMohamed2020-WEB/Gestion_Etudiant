package com.test.etudinat.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.test.etudinat.dao.EtudiantDao;
import com.test.etudinat.entities.Departement;
import com.test.etudinat.entities.Etudiant;

@RestController
@RequestMapping(value = "/etudiant")
@CrossOrigin
public class EtudiantController {
	
	@Autowired
	EtudiantDao etudiantDao;

	@GetMapping(value = "/get")
	public List<Etudiant> getAllEtudiant() {
		return this.etudiantDao.findAll();
	}
	
	//findByNomEContainingAndNomEContaining   findAncienEtudiant
	

	
	  @GetMapping(value = "/ancien") public List<Departement> getByAncien() {
	  return this.etudiantDao.findAncienEtudiant(); }
	 
	@GetMapping(value = "/getbynom/{x}/{z}")
	public List<Etudiant> getByNom(@PathVariable String x,@PathVariable String z) {
		return this.etudiantDao.findByNomEContainingAndNomEContaining(x, z);
	}
	
	@GetMapping(value = "/getByDateEntre")
	public List<Etudiant> getAllByDateEntreDesc() {
		return this.etudiantDao.findBydateEntreDESC();
	}

	// optional cad tu prent empty
	@GetMapping(value = "/get/{codeClient}")
	public Optional<Etudiant> getAllById(@PathVariable Long numE) {
		return this.etudiantDao.findById(numE);
	}

	@PostMapping(value = "/post")
	public Etudiant postEtudiant(@RequestBody Etudiant etudiant) {
		return this.etudiantDao.save(etudiant);
	}


}
