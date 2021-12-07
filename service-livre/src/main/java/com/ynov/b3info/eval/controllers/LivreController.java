package com.ynov.b3info.eval.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.b3info.eval.models.Livre;
import com.ynov.b3info.eval.repository.LivreRepository;

@RestController @RequestMapping("/api/livre")

public class LivreController {
	
	@Autowired
    private LivreRepository LivreRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Livre>> getLivre() {
		return ResponseEntity.ok(LivreRepository.findAll());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Livre>> getLivre(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(LivreRepository.findById(id));
	}

	@RequestMapping(value = "/search/{title}/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Livre>> searchLivreByName(@PathVariable("title") String title) {
		return ResponseEntity.ok(LivreRepository.findAll());
	}
	
	@RequestMapping(value = "/{title}/{author}/{releaseDate}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Livre> createLivre(@PathVariable("title") String title,@PathVariable("author") String author, @PathVariable("releaseDate") String releaseDate) {
		Livre livre = new Livre();
		livre.settitle(title);
		livre.setauthor(author);
		livre.setreleaseDate(releaseDate);
		
		return ResponseEntity.ok(LivreRepository.save(livre));
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Livre> updateLivre(@PathVariable("id") Integer id, @RequestBody Livre newLivre) {
		Optional<Livre> optLivre = LivreRepository.findById(id);
		
		if (optLivre.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Livre livre = optLivre.get();
		livre.settitle(newLivre.gettitle());
		livre.setauthor(newLivre.getauthor());
		livre.setreleaseDate(newLivre.getreleaseDate());
		return ResponseEntity.ok(LivreRepository.save(livre));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Livre> deleteLivre(@PathVariable("id") Integer id) {
		Optional<Livre> optLivre = LivreRepository.findById(id);
		if (optLivre.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Livre livre = optLivre.get();
		LivreRepository.delete(livre);
		return ResponseEntity.ok(livre);
	}
}
	
	
}
