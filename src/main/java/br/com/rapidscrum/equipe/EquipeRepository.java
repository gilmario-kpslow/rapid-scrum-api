package br.com.rapidscrum.equipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rapidscrum.equipe.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
