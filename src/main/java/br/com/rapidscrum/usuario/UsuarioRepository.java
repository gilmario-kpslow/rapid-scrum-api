package br.com.rapidscrum.usuario;

import br.com.rapidscrum.seguranca.UsuarioDetalhes;
import java.util.Optional;
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

    Usuario findByUsername(String username);

    @Query("SELECT u.username as username, c.password as password, c.ativo as accountNonExpired, c.ativo as accountNonLocked, c.ativo as enabled, c.ativo as credentialsNonExpired FROM Credencial c JOIN c.usuario u where u.username = :username")
    UsuarioDetalhes getUserDetails(@Param("username") String username);

    Optional<Boolean> existsByUsername(String username);

    Optional<Boolean> existsByEmail(String email);

}
