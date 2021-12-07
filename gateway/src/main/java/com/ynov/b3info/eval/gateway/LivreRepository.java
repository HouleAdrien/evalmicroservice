package com.ynov.b3info.eval.gateway;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(path = "/api/livre", name = "EVAL-LIVRE")
public interface LivreRepository {

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Livre>> getLivres();
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Livre>> getLivre(@PathVariable("id") Integer id);

	@RequestMapping(value = "/search/{title}/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Livre>> searchLivresByName(@PathVariable("title") String title);
	
	@RequestMapping(value = "/{title}/{author}/{releasedate}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Livre> createLivre(@PathVariable("title") String title,@PathVariable("title") String author, @PathVariable("price") Integer price);
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Livre> updateLivre(@PathVariable("id") Integer id, @RequestBody Livre newLivre);
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Livre> deleteLivre(@PathVariable("id") Integer id);
}
