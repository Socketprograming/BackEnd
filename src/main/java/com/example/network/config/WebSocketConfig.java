package com.example.network.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;

    public WebSocketConfig(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //엔드포인트 정의, url에 웹소켓 핸들러 매핑
        registry.addHandler(webSocketHandler, "/board")
                //클라이언트에서 웹소켓 서버에 요청시 모든 요청을 수용
                .setAllowedOrigins("http://localhost:8080");

        //엔드포인트 정의, url에 웹소켓 핸들러 매핑
        registry.addHandler(webSocketHandler, "/tryitout/H0STCNT0")
                //클라이언트에서 웹소켓 서버에 요청시 모든 요청을 수용
                .setAllowedOrigins("http://ops.koreainvestment.com:21000");
    }


}