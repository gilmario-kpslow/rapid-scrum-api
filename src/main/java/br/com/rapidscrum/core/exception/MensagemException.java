/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.core.exception;

import java.time.LocalDateTime;

/**
 *
 * @author gilmario
 */
public class MensagemException {

    private final LocalDateTime dataOcorrencia;
    private final String mensagem;
    private final String detalhes;
    private final StatusMensagem status;

    public MensagemException(String mensagem, String detalhes, StatusMensagem status) {
        this.dataOcorrencia = LocalDateTime.now();
        this.mensagem = mensagem;
        this.status = status;
        this.detalhes = detalhes;
    }

    public LocalDateTime getDataOcorrencia() {
        return dataOcorrencia;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public StatusMensagem getStatus() {
        return status;
    }

}
