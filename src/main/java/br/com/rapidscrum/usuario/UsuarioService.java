package br.com.rapidscrum.usuario;

import br.com.rapidscrum.core.generic.GenericService;
import org.springframework.stereotype.Service;

/**
 *
 * @author gilmario
 */
@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRepository> {

    public Usuario login(String username, String password) {
        return this.repository.findByUsername(username);
    }

    public Usuario loadByUsername(String username) {
        return this.repository.findByUsername(username);
    }

}