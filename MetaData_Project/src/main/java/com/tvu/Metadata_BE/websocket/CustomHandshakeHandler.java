/*package com.tvu.Metadata_BE.websocket;

import java.util.Map;
import java.util.UUID;

import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class CustomHandshakeHandler extends DefaultHandshakeHandler {
    @Override
    protected Principal determineUser(ServerHttpRequest request,
                                      WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {
        // generate user name by UUID
        return new StompPrincipal(UUID.randomUUID().toString());
    }
}*/