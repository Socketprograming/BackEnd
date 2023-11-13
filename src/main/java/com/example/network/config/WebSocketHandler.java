package com.example.network.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
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

        // 메시지 파싱
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(message.getPayload());
        JsonNode bodyNode = rootNode.path("body");
        String trId = bodyNode.path("input").path("tr_id").asText();

        // 주식 정보 요청 처리
        if ("H0STCNT0".equals(trId)) {
            // 예시: 실제 주식 정보를 얻어오는 로직을 구현하고 응답을 생성
//            String stockInfo = getStockInfo();
            sendWebSocketMessage(session, stockInfo);
        }
    }

    // WebSocket 클라이언트로 메시지 전송
    public void sendWebSocketMessage(String message) throws IOException {
        for (WebSocketSession client : CLIENTS) {
            TextMessage textMessage = new TextMessage(message);
            System.out.println("Sending message to WebSocket client: " + message);
            client.sendMessage(textMessage);
        }
    }
}