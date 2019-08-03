/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.projeto;

import br.com.rapidscrum.rapidscrum.core.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gilmario
 */
@RestController()
@RequestMapping("projeto")
public class ProjetoController extends GenericController<Projeto, ProjetoRepository, ProjetoService> {

}
