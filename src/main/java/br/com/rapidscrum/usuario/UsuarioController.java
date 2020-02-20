package br.com.rapidscrum.usuario;

import br.com.rapidscrum.core.generic.GenericController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gilmario
 */
@RestController
@RequestMapping("usuario")
public class UsuarioController extends GenericController<Usuario, UsuarioRepository, UsuarioService> {

    @PostMapping(value = "registrar")
    public void registrar(@RequestBody UsuarioRegistroRequest registro) throws UsuarioException {
        this.service.registrar(registro);
    }

}
