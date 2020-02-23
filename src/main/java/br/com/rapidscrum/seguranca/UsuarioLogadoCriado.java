/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.seguranca;

import br.com.rapidscrum.usuario.Usuario;

/**
 *
 * @author gilmario
 */
public class UsuarioLogadoCriado {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioLogadoCriado(Usuario usuario) {
        this.usuario = usuario;
    }

}
