package com.example.socketiodemo.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
@Log4j2
public class SocketIOConfiguration {

    private SocketIOServer server;

    private final String HOSTNAME;
    private final int PORT;

    public SocketIOConfiguration(@Value("${socket.hostname}") String hostname,
                                 @Value("${socket.port}") int port){
        this.HOSTNAME = hostname;
        this.PORT = port;
    }

    @Bean
    public SocketIOServer startSocketIOServer(){
        Configuration configuration = new Configuration();
        configuration.setHostname(HOSTNAME);
        configuration.setPort(PORT);

        server = new SocketIOServer(configuration);
        server.start();

        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                log.info("Ada user baru terkoneksi");
            }
        });

        server.addDisconnectListener(new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient socketIOClient) {
                log.info("Ada user meninggalkan koneksi");
            }
        });

        return server;
    }

    @PreDestroy
    public void stopSocketIOServer(){
        server.start();
    }
}
