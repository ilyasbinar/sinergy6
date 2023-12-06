package com.example.socketiodemopr.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Component
@Log4j2
public class SocketIOConfig {

    private final String SOCKETHOST;

    private final int SOCKETPORT;
    private SocketIOServer server;


    public SocketIOConfig(@Value("${socket.host}") String sockethost,
                          @Value("${socket.port}")int socketport) {
        SOCKETHOST = sockethost;
        SOCKETPORT = socketport;
    }

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname(SOCKETHOST);
        config.setPort(SOCKETPORT);
        server = new SocketIOServer(config);
        server.start();
        server.addConnectListener(
                client -> log.info("new user connected with socket "
                        + client.getSessionId()));

        server.addDisconnectListener(
                client -> client
                        .getNamespace()
                        .getAllClients()
                        .forEach(data-> log.info("user disconnected "+data.getSessionId().toString()))
        );
        return server;
    }

    @PreDestroy
    public void stopSocketIOServer() {
        this.server.stop();
    }
}
