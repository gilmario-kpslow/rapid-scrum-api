package br.com.rapidscrum.modulo;

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

import br.com.rapidscrum.modulo.Modulo;

@CrossOrigin
@RestController
@RequestMapping("modulos")

public class ModuloResource {
	
	@Autowired
	private ModuloService moduloService; 
	
	@PostMapping
	public ResponseEntity<Modulo> save(@RequestBody Modulo modulo) {
		modulo = moduloService.save(modulo);
		return ResponseEntity.ok().body(modulo);
	}
	
	@GetMapping
	public ResponseEntity<List<Modulo>> findAll() {
		List<Modulo> lista = moduloService.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Modulo> findById(@PathVariable Long id) {
		Modulo modulo = moduloService.findById(id);
		return ResponseEntity.ok().body(modulo);
	}
	
	@PutMapping
	public ResponseEntity<Modulo> update(@RequestBody Modulo modulo) {
		modulo = moduloService.update(modulo);
		return ResponseEntity.ok().body(modulo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		moduloService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
