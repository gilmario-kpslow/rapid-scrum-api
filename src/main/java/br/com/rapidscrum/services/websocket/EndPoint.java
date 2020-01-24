package br.com.rapidscrum.services.websocket;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
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
