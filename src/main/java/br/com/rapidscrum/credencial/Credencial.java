/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.credencial;

import br.com.rapidscrum.core.generic.GenericEntity;
import br.com.rapidscrum.usuario.Usuario;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author gilmario
 */
@Entity
public class Credencial extends GenericEntity implements Serializable {

    @Column(length = 255, nullable = false)
    @NotBlank
    @Length(min = 3)
    private String password;
    @JoinColumn
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(nullable = false)
    private LocalDateTime validadeSenha;
    @JoinColumn(nullable = false, columnDefinition = "boolean not null default true")
    private boolean ativo;

    public Credencial() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getValidadeSenha() {
        return validadeSenha;
    }

    public void setValidadeSenha(LocalDateTime validadeSenha) {
        this.validadeSenha = validadeSenha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
