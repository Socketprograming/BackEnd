package com.example.network.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//웹소켓 서버를 구현
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private static Set<WebSocketSession> CLIENTS = Collections.synchronizedSet(new HashSet<>());

    //client 접속 시 호출
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(session.toString());

        if (CLIENTS.contains(session)) {
            System.out.println("이미 연결된 세션입니다. > " + session);
        } else {
            CLIENTS.add(session);
            System.out.println("새로운 세션입니다. > " + session);
        }
    }

    //client 접속 해제 시 호출
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        CLIENTS.remove(session);
        System.out.println("세션을 닫습니다. : " + session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("입력된 메세지입니다. > " + message);

        for (WebSocketSession client : CLIENTS) {
            System.out.println("메세지를 전달합니다. > " + message);
            client.sendMessage(message);
        }
    }
}
