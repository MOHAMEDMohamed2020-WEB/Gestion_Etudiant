package com.test.etudinat.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Specialite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdSpec;
	private String LibelleSpec;
	
	@OneToMany( mappedBy="specialite")
	private Collection <Etudiant> etudiants;

	public Specialite() {
		
	}

	public Specialite(String libelleSpec, Collection<Etudiant> etudiants) {
		
		LibelleSpec = libelleSpec;
		this.etudiants = etudiants;
	}

	public Long getIdSpec() {
		return IdSpec;
	}

	public void setIdSpec(Long idSpec) {
		IdSpec = idSpec;
	}

	public String getLibelleSpec() {
		return LibelleSpec;
	}

	public void setLibelleSpec(String libelleSpec) {
		LibelleSpec = libelleSpec;
	}
	@JsonIgnore()
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	

}
