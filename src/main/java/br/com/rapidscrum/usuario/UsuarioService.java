package br.com.rapidscrum.usuario;

import br.com.rapidscrum.core.generic.GenericService;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author gilmario
 */
@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRepository> {

    public Optional<Boolean> existsByUsername(String username) {
        return this.repository.existsByUsername(username);
    }

}
