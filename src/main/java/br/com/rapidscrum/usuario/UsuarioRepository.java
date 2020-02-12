package br.com.rapidscrum.usuario;

import br.com.rapidscrum.seguranca.UsuarioDetalhes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

/**
 *
 * @author gilmario
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

    @Query("SELECT u FROM Usuario u where username = :username")
    public UsuarioDetalhes getUserDetails(@Param("username") String username);

}
