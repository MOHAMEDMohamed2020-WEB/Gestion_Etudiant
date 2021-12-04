package com.test.etudinat.entities;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long NumE;
	private String nomE;
	private int Niveau;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date DateEntre;
	private double Moyenne;
	//departement
	@ManyToOne
	@JoinColumn(name="IdSpec")
	private Specialite specialite;
	@ManyToOne
	@JoinColumn(name="departement")
	private Departement departement;

	public Etudiant() {
		
	}

	public Etudiant(String nomE, int niveau, Date dateEntre, double moyenne, Specialite specialite,
			Departement departement) {
		
		nomE = nomE;
		Niveau = niveau;
		DateEntre = dateEntre;
		Moyenne = moyenne;
		this.specialite = specialite;
		this.departement = departement;
	}

	public Long getNumE() {
		return NumE;
	}

	public void setNumE(Long numE) {
		NumE = numE;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		nomE = nomE;
	}

	public int getNiveau() {
		return Niveau;
	}

	public void setNiveau(int niveau) {
		Niveau = niveau;
	}

	public Date getDateEntre() {
		return DateEntre;
	}

	public void setDateEntre(Date dateEntre) {
		DateEntre = dateEntre;
	}

	public double getMoyenne() {
		return Moyenne;
	}

	public void setMoyenne(double moyenne) {
		Moyenne = moyenne;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	

}
