package br.com.rapidscrum.rapidscrum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rapidscrum.rapidscrum.domain.Desenvolvedor;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {

}
