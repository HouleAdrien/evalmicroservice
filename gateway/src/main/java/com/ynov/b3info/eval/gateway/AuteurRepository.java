package com.ynov.b3info.eval.gateway;
import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(path = "/api/auteur", name = "EVAL-AUTEUR")
public interface AuteurRepository {

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Auteur>> getAuteurs();
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Auteur>> getAuteur(@PathVariable("id") Integer id);

	@RequestMapping(value = "/search/{name}/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<Auteur>> searchAuteursByName(@PathVariable("name") String name);
	
	@RequestMapping(value = "/{name}/{birth}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Auteur> createAuteur(@PathVariable("name") String name,@PathVariable("birth") String birth);
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Auteur> updateAuteur(@PathVariable("id") Integer id, @RequestBody Livre newLivre);
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Auteur> deleteAuteur(@PathVariable("id") Integer id);
}
