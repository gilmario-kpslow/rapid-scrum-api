/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.usuario;

import br.com.rapidscrum.rapidscrum.core.generic.GenericEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author gilmario
 */
@Entity
public class Usuario extends GenericEntity implements Serializable {

    @Column(length = 40, nullable = false)
    @NotBlank
    @Length(min = 3)
    private String nome;
    @Column(length = 40, nullable = false)
    @NotBlank
    @Length(min = 3)
    private String sobrenome;
    @Column(length = 255, nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
