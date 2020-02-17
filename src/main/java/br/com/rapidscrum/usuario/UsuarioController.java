package br.com.rapidscrum.usuario;

import br.com.rapidscrum.core.generic.GenericController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gilmario
 */
@RestController()
@RequestMapping("usuario")
public class UsuarioController extends GenericController<Usuario, UsuarioRepository, UsuarioService> {

    @Override
    public Usuario salvar(Usuario e) {
        return super.salvar(e);
    }

    @GetMapping
    public Usuario registrar(UsuarioRegistroRequest registro) {

    }

}
