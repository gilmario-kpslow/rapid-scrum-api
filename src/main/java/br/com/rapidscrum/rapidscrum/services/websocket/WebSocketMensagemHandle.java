/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.services.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *
 * @author gilmario
 */
@Component
public class WebSocketMensagemHandle extends TextWebSocketHandler{
    
    private List<WebSocketSession> sessions = new ArrayList<>();

    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Desconectado------------------------------------------------------");
        sessions.remove(session);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Conectado---------------------------------------------------------");
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        // A message has been received
        System.out.println("MEnsagem----------------------------------------------------------");
        sessions.forEach(s -> {
            try {
                s.sendMessage(textMessage);
            } catch (IOException ex) {
                Logger.getLogger(WebSocketMensagemHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //System.out.println("Message received: " + textMessage.getPayload());
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        super.handleBinaryMessage(session, message); //To change body of generated methods, choose Tools | Templates.
        System.out.println("------------------------------------------------------------------");
    }
    
    
}
