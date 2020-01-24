package br.com.rapidscrum.projeto;

import br.com.rapidscrum.core.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gilmario
 */
@RestController
@RequestMapping("projeto")
public class ProjetoController extends GenericController<Projeto, ProjetoRepository, ProjetoService> {

}
