package br.com.rapidscrum.projeto;

import br.com.rapidscrum.core.generic.GenericEntity;
import br.com.rapidscrum.usuario.Usuario;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
public class Projeto extends GenericEntity implements Serializable {

    @Length(min = 3, max = 30)
    @Column(length = 30, nullable = false)
    @NotBlank
    private String nome;
    @Length(min = 3, max = 10)
    @Column(length = 10, nullable = false)
    @NotBlank
    private String sigla;
    @Length(max = 2048)
    @Column(length = 2048, nullable = true)
    @NotBlank
    private String descricao;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Usuario owner;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getOwner() {
        return owner;
    }

    public void setOwner(Usuario owner) {
        this.owner = owner;
    }

}
