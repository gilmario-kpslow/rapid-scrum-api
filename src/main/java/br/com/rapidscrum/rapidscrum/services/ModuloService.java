package br.com.rapidscrum.rapidscrum.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rapidscrum.rapidscrum.domain.Modulo;
import br.com.rapidscrum.rapidscrum.domain.Sistema;
import br.com.rapidscrum.rapidscrum.repositories.ModuloRepository;
import br.com.rapidscrum.rapidscrum.repositories.SistemaRepository;

@Service
public class ModuloService {
	
	@Autowired
	private ModuloRepository repository;
	
	@Autowired
	private SistemaRepository sistemaRepository;
	
	// Gilmário, fiquei um pouco em dúvida na implementação do método save por causa do relacionamento com Sistema.
	// Fiz recebendo apenas o ID de um sistema já cadastrado. Daí eu seto o sistema no módulo passado e salvo no banco.
	// Mas no caso de o ID passado não existir? Como lançar uma exceção com uma msg amigável para o usuário?
	public Modulo save(Modulo modulo) {
		Optional<Sistema> optional = sistemaRepository.findById(modulo.getSistema().getId());
		Sistema sistema = optional.orElseThrow(null);
		modulo.setSistema(sistema);
		return repository.save(modulo);
	}
	
	public List<Modulo> findAll() {
		return repository.findAll();
	}
	
	public Modulo findById(Long id) {
		Optional<Modulo> optional = repository.findById(id);
		return optional.orElseThrow(null);
	}
	
	public Modulo update(Modulo modulo) {
		return repository.save(modulo);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
