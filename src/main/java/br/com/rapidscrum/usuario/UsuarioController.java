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

    @GetMapping(value = "registrar")
    public void registrar(UsuarioRegistroRequest registro) {
        this.service.registrar(registro);
    }

}
