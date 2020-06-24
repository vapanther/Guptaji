/*package com.tvu.Metadata_BE.websocket;

import java.util.Date;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private static final String WS_MESSAGE_TRANSFER_DESTINATION = "/topic/greetings";

    GreetingService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendMessages() {
        simpMessagingTemplate.convertAndSend(WS_MESSAGE_TRANSFER_DESTINATION,
            "Hallo " + " at " + new Date().toString());
    }
}*/