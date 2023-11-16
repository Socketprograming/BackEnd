package com.example.network.config;

import com.example.network.dto.StockDto;
import com.example.network.response.BaseResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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

    //클라이언트에서 websocket으로 들어오는 메세지를 처리함.
    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage message) throws Exception {
        System.out.println("입력된 메세지입니다. > " + message);

        String payload = message.getPayload();

        try {
            // open websocket
            final WebSocketClientEndpoint clientEndPoint = new WebSocketClientEndpoint();

            Session session = clientEndPoint.connect(new URI("ws://ops.koreainvestment.com:21000"));
            clientEndPoint.sendMessage(payload);

            // add listener
            clientEndPoint.addMessageHandler(new WebSocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) throws IOException {

                    // Split the message using the '^' delimiter
                    String[] parts = message.split("\\^");
                    String[] codepart = parts[0].split("\\|");

                    // Check if the array has enough elements
                    if (parts.length >= 4) {
                        // Access individual parts based on their position
                        String stockCode = codepart[3];
                        String timestamp = parts[1];
                        String lastPrice = parts[2];
                        String rate = parts[5];

                        // Print or use the extracted values
//                        System.out.println("Stock Code: " + stockCode);
//                        System.out.println("Timestamp: " + timestamp);
//                        System.out.println("Last Price: " + lastPrice);
                        // ... print or use other values as needed

                        StockDto stockDtoReal = new StockDto();
                        stockDtoReal.setStockCode(stockCode);
//                        stockDtoReal.setRate(rate);
                        stockDtoReal.setLastPrice(lastPrice);

                        String data = "Stock Code: " + stockCode + "\nLast Price: " + lastPrice + "\nrate: " + rate;
                        sendWebSocketMessage(data);
//                        sendWebSocketMessage(message);

                    } else {
//                        System.err.println("Invalid message format: " + message);
                        sendWebSocketMessage(message);
                    }
                }
            });

            // send message to websocket
//            clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");

            // wait 5 seconds for messages from websocket
//            while(true) {
            Thread.sleep(5000);
//            }

        } catch (InterruptedException ex) {
//            System.err.println("InterruptedException exception: " + ex.getMessage());
            sendWebSocketMessage("Invalid message format: " + ex.getMessage());
        } catch (URISyntaxException ex) {
//            System.err.println("URISyntaxException exception: " + ex.getMessage());
            sendWebSocketMessage("URISyntaxException exception: " + ex.getMessage());
        }

    }

    // WebSocket 클라이언트로 메시지 전송, 클라이언트가 이 메세지를 받아서 처리를 수행함.
    public void sendWebSocketMessage(String message) throws IOException {
        for (WebSocketSession client : CLIENTS) {
            TextMessage textMessage = new TextMessage(message);
            System.out.println("Sending message to WebSocket client: \n" + message);
            client.sendMessage(textMessage);
        }
    }
}