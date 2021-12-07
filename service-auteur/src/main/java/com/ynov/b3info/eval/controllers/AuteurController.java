package com.ynov.b3info.eval.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.b3info.eval.models.Auteur;
import com.ynov.b3info.eval.repository.AuteurRepository;
@RestController
@RequestMapping("/api/auteur")
public class AuteurController {
	
	@Autowired
	private AuteurRepository auteurRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Auteur>> getAuteurs() {
		return ResponseEntity.ok(auteurRepository.findAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Auteur>> getAuteur(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(auteurRepository.findById(id));
	}

	@RequestMapping(value = "/search/{name}/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Auteur>> searchAuteursByName(@PathVariable("name") String name) {
		return ResponseEntity.ok(auteurRepository.findByNameStartingWith(name));
	}
	
	@RequestMapping(value = "/{name}/{birth}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Auteur> createAuteur(@PathVariable("name") String name,@PathVariable("birth") String birth) {
		Auteur auteur = new Auteur();
		auteur.setName(name);
		auteur.setBirth(birth);
		
		return ResponseEntity.ok(auteurRepository.save(auteur));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Auteur> updateAuteur(@PathVariable("id") Integer id, @RequestBody Auteur newAuteur) {
		Optional<Auteur> optAuteur = auteurRepository.findById(id);
		
		if (optAuteur.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Auteur auteur = optAuteur.get();
		auteur.setName(newAuteur.getName());
		auteur.setBirth(newAuteur.getBirth());
		
		return ResponseEntity.ok(auteurRepository.save(auteur));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Auteur> deleteAuteur(@PathVariable("id") Integer id) {
		Optional<Auteur> optAuteur = auteurRepository.findById(id);
		
		if (optAuteur.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Auteur auteur = optAuteur.get();
		auteurRepository.delete(auteur);
		
		return ResponseEntity.ok(auteur);
	}
	
}