package com.test.etudinat.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdDepartement;
	private String LibelleDepartement;

	@OneToMany( mappedBy="departement")
	private Collection <Etudiant> etudiants;

	public Departement() {
			}

	
	public Departement(String libelleDepartement, Collection<Etudiant> etudiants) {
	
		LibelleDepartement = libelleDepartement;
		this.etudiants = etudiants;
	}


	public String getLibelleDepartement() {
		return LibelleDepartement;
	}

	public void setLibelleDepartement(String libelleDepartement) {
		LibelleDepartement = libelleDepartement;
	}

	@JsonIgnore()
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	
}
