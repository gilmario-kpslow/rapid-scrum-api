/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.services.websocket;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

/**
 *
 * @author gilmario
 */
@ServerEndpoint(value = "game", configurator = SpringConfigurator.class)
public class EndPoint {

    @OnOpen
    public void connect(Session session) {
        System.out.println("SESSION");
    }

}
