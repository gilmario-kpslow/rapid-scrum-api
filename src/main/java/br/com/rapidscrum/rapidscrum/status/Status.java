/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.status;

import java.time.LocalDateTime;

/**
 *
 * @author gilmario
 */
public class Status {
    
    private String nomeApi;
    private String versaoApi;
    private LocalDateTime ultimaAtualizacao;

    public Status() {
        nomeApi = "RapidScrum";
        versaoApi = "0.0.1-SNAPSHOT";
        ultimaAtualizacao = LocalDateTime.now();
    }

    
    
    public String getNomeApi() {
        return nomeApi;
    }

    public void setNomeApi(String nomeApi) {
        this.nomeApi = nomeApi;
    }

    public String getVersaoApi() {
        return versaoApi;
    }

    public void setVersaoApi(String versaoApi) {
        this.versaoApi = versaoApi;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    
    
    
}
