package br.com.rapidscrum.usuario;

import br.com.rapidscrum.core.generic.GenericEntity;
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
    private String nomeCompleto;
    @Column(length = 255, nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;
    @Column(length = 40, nullable = false)
    @NotBlank
    @Length(min = 8)
    private String username;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

}
