package com.minwoo.nunutalk.config;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

public class StompConfig implements WebSocketMessageBrokerConfigurer {

    // 웹소켓 핸드쉐이크 하는 엔드 포인트
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 채팅 어플리케이션 prefix
        registry.setApplicationDestinationPrefixes("/nunutalk");
        // 브로커 엔드포인트
        registry.enableSimpleBroker("/chat-room");
        // 순서 대로 발행
        registry.setPreservePublishOrder(true);
    }


}
