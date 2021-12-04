package com.test.etudinat.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.test.etudinat.entities.Departement;
import com.test.etudinat.entities.Etudiant;

@RepositoryRestResource
//@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
	@RestResource(path = "/Q1")
	@Query("select e from Etudiant e where e.departement.LibelleDepartement ='Informatique' order by e.DateEntre desc ")
	List<Etudiant> findBydateEntreDESC();

//	@RestResource(path = "/Q2")
//	//List<Etudiant> findByNomEContainingAndNomEContaining(String m, String l);
//	Collection<Etudiant> findByNomEContaining(String m);
	
	@RestResource(path = "/Q2")
	List<Etudiant> findByNomEContainingAndNomEContaining(String m, String l);
	
	@RestResource(path = "/Q3")
	@Query("select e.departement from Etudiant e where e.DateEntre=(select min(e.DateEntre) from Etudiant e)")
	List<Departement> findAncienEtudiant();
}
