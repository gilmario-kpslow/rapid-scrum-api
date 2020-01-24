package br.com.rapidscrum.sistema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Long> {

}
