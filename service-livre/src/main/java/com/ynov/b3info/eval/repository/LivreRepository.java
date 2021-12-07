package com.ynov.b3info.eval.repository;

import com.ynov.b3info.eval.models.Livre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LivreRepository extends CrudRepository<Livre, Integer> {
	public Iterable<Livre> findByNameStartingWith(String name);
	public Iterable<Livre> findLivreByAuthor(String author);
    public List<Livre> findByAuthor(String author);
}