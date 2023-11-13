package com.example.network.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

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

//                //핸드셰이크 요청을 인터셉트할 인터셉터
//                .addInterceptors(new HttpSessionHandshakeInterceptor())
//                //브라우저에서 websocket지원하지 않는 경우를 대비해 어플리케이션 코드 변경 없이 런타임이 필요할 때 대체
//                .withSockJS();


//    @Bean
//    //WebSocket의 메세지 버퍼 크기, 유휴시간 등, 런타임 특성을 제어하는 프로퍼티
//    public ServletServerContainerFactoryBean createWebSocketContainer(){
//        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
//        container.setMaxTextMessageBufferSize(8192);
//        container.setMaxBinaryMessageBufferSize(8192);
//        return container;
//    }

}