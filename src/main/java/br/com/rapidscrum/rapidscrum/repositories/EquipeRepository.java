package br.com.rapidscrum.rapidscrum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rapidscrum.rapidscrum.domain.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
