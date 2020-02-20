package br.com.rapidscrum.usuario;

import br.com.rapidscrum.core.generic.GenericService;
import br.com.rapidscrum.credencial.CredencialService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void registrar(UsuarioRegistroRequest registro) throws UsuarioException {
        // Valida Email
        validaExisteByUsername(registro.getUsername());

        // Valida Username
        validaExisteByEmail(registro.getEmail());

        Usuario usuario = this.repository.save(registro.getUsuario());
        this.credencialService.create(usuario, registro.getSenha());

    }

    protected void validaExisteByUsername(String username) throws UsuarioException {
        Optional<Boolean> existe = this.repository.existsByUsername(username);
        if (existe.get()) {
            throw new UsuarioException("Username invalido ou ja cadastrado");
        }
    }

    protected void validaExisteByEmail(String email) throws UsuarioException {
        Optional<Boolean> existe = this.repository.existsByEmail(email);
        if (existe.get()) {
            throw new UsuarioException("Email invalido ou ja cadastrado");
        }
    }

    public Usuario findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

}
