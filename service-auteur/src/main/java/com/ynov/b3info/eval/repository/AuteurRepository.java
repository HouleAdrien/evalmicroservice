package com.ynov.b3info.eval.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ynov.b3info.eval.models.Auteur;

public interface AuteurRepository extends CrudRepository<Auteur, Integer> {
	public Iterable<Auteur> findByNameStartingWith(String name);

}