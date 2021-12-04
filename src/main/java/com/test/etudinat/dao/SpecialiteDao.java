package com.test.etudinat.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.etudinat.entities.Specialite;

@RepositoryRestResource
public interface SpecialiteDao extends JpaRepository<Specialite, Long> {

}
