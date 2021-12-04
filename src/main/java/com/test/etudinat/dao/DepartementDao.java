package com.test.etudinat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.etudinat.entities.Departement;

@RepositoryRestResource
public interface DepartementDao  extends JpaRepository<Departement, Long>{
	
	

}
