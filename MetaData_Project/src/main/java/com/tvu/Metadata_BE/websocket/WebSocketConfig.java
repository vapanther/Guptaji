package com.tvu.Metadata_BE.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
		System.out.println("Connection Established...");
	}


	public void registerStompEndpoints(StompEndpointRegistry registry) {
		System.out.println("Connection Established...");
		//registry.addEndpoint("/result-websocket").withSockJS();
		registry.addEndpoint("/ws").setAllowedOrigins("*");
		registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
	}
}
