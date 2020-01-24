/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.seguranca;

import br.com.rapidscrum.usuario.Usuario;
import br.com.rapidscrum.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gilmario
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario login(@RequestBody LoginRequest login) {
        return this.usuarioService.login(login.getUsername(), login.getPassword());
    }
}
