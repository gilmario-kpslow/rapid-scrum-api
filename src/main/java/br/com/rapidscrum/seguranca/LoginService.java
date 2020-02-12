/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.seguranca;

import br.com.rapidscrum.seguranca.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 *
 * @author gilmario
 */
@Service
public class LoginService {

    @Autowired
    private UsuarioDetalhesService usuarioDetalhesService;

    @Autowired
    private JWTUtil jWTUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginResponse login(String username, String password) {
        authenticate(username, password);
        final UsuarioDetalhes detalhes = usuarioDetalhesService.loadUserByUsername(username);
        final String token = jWTUtil.generateToken(detalhes);
        return new LoginResponse(token);
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

}
