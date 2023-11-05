package com.example.network.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
        //엔드포인트 정의
        registry.addHandler(webSocketHandler, "/board")
                //클라이언트에서 웹소켓 서버에 요청시 모든 요청을 수용
                .setAllowedOrigins("*");
    }

//    @Bean
//    public WebSocketHandler signalingSocketHandler(){
//        return new WebSocketHandler();
//    }
}
