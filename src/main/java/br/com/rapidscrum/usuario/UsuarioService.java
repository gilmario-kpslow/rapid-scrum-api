package br.com.rapidscrum.usuario;

import br.com.rapidscrum.core.generic.GenericService;
import br.com.rapidscrum.credencial.CredencialService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gilmario
 */
@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRepository> {

    @Autowired
    private CredencialService credencialService;

    public Optional<Boolean> existsByUsername(String username) {
        return this.repository.existsByUsername(username);
    }

    void registrar(UsuarioRegistroRequest registro) {
        Usuario usuario = this.repository.save(registro.getUsuario());
        this.credencialService.create(usuario, registro.getSenha());

    }

}
