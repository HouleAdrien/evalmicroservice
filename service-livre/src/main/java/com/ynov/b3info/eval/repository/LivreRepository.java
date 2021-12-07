package com.ynov.b3info.eval.repository;

import com.ynov.b3info.eval.models.Livre;
import org.springframework.data.repository.CrudRepository;

public interface LivreRepository extends CrudRepository<Livre, Integer> {
	public Iterable<Livre> findByNameStartingWith(String name);
}