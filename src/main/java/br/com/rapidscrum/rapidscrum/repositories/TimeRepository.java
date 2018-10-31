package br.com.rapidscrum.rapidscrum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rapidscrum.rapidscrum.domain.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

}
