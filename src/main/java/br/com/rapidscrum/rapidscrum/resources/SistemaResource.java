package br.com.rapidscrum.rapidscrum.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rapidscrum.rapidscrum.domain.Sistema;
import br.com.rapidscrum.rapidscrum.services.SistemaService;

@CrossOrigin
@RestController
@RequestMapping(value = "sistemas")
public class SistemaResource {

	@Autowired
	private SistemaService sistemaService;

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Sistema sistema) {
		sistema = sistemaService.save(sistema);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sistema.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Sistema>> findAll() {
		List<Sistema> lista = sistemaService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Sistema> findById(@PathVariable Long id) {
		Sistema sistema = sistemaService.findById(id);
		return ResponseEntity.ok().body(sistema);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Sistema sistema, @PathVariable Long id) {
		sistema.setId(id);
		sistema = sistemaService.update(sistema);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		sistemaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
