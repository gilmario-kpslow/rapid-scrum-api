package br.com.rapidscrum.rapidscrum.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rapidscrum.rapidscrum.domain.Sistema;
import br.com.rapidscrum.rapidscrum.repositories.SistemaRepository;

@Service
public class SistemaService {

	@Autowired
	private SistemaRepository repository;

	public Sistema save(Sistema sistema) {
		return repository.save(sistema);
	}

	public List<Sistema> findAll() {
		return repository.findAll();
	}

	public Sistema findById(Long id) {
		Optional<Sistema> sistema = repository.findById(id);
		return sistema.orElseThrow(null);
	}

	public Sistema update(Sistema sistema) {
		return repository.save(sistema);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
