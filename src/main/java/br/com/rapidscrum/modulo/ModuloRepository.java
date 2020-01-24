package br.com.rapidscrum.modulo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rapidscrum.modulo.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {

}
