package com.test.etudinat.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.test.etudinat.dao.DepartementDao;
import com.test.etudinat.entities.Departement;
import com.test.etudinat.entities.Etudiant;

@RestController
@RequestMapping(value = "/dept")
@CrossOrigin
public class DepartementController {

	@Autowired
	DepartementDao departementDao;

	@GetMapping("/get")
	public ResponseEntity<List<Departement>> getAll() {
		List<Departement> list = (List<Departement>) departementDao.findAll();
		if (!list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/gett")
	public List<Departement> getAllDepartement() {
		return this.departementDao.findAll();
	}
	
	@GetMapping(value="/get/{id}")
	public Departement getDepartementById(@PathVariable Long id) 
	{
		return this.departementDao.findById(id).get();
	}
	
	 @GetMapping("/list")
	    public String listArticles(Model model) {
	    	List<Departement>ls = (List<Departement>) departementDao.findAll();
	    	if(ls.isEmpty())
	    		ls = null;
	    	//model.addAttribute("articles", null);
	        model.addAttribute("depts",ls );
	        return "Departement/ListDepartement";
	    }


}
