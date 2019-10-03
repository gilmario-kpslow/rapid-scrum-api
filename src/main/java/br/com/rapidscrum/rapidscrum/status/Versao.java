package br.com.rapidscrum.rapidscrum.status;

import java.time.LocalDateTime;

/**
 *
 * @author gilmario
 */
public class Versao {

    private String nome;
    private String grupo;
    private String artefato;
    private String versao;
    private LocalDateTime dataBuild;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getArtefato() {
        return artefato;
    }

    public void setArtefato(String artefato) {
        this.artefato = artefato;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public LocalDateTime getDataBuild() {
        return dataBuild;
    }

    public void setDataBuild(LocalDateTime dataBuild) {
        this.dataBuild = dataBuild;
    }

}
