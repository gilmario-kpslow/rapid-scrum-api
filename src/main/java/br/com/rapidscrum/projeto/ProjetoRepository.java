package br.com.rapidscrum.projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gilmario
 */
@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
