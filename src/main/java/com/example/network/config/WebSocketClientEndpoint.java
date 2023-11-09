package com.example.network.config;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;

@ClientEndpoint
public class WebSocketClientEndpoint {
    private final Logger logger = LoggerFactory.getLogger(WebSocketClientEndpoint.class);

    Session userSession = null;
    private MessageHandler messageHandler;

    public WebSocketClientEndpoint(URI uri) {
        try {
            WebSocketContainer container = ContainerProvider
                    .getWebSocketContainer();
            container.connectToServer(this, uri);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("opening websocket");
        String requestMessage = "{\n" +
                "         \"header\":\n" +
                "         {\n" +
                "                  \"approval_key\": \"f26c2cf7-d2ef-4f94-8ff5-4b1d089072cb\",\n" +
                "                  \"custtype\":\"P\",\n" +
                "                  \"tr_type\":\"1\",\n" +
                "                  \"content-type\":\"utf-8\"\n" +
                "         },\n" +
                "         \"body\":\n" +
                "         {\n" +
                "                  \"input\":\n" +
                "                  {\n" +
                "                           \"tr_id\":\"H0STCNT0\",\n" +
                "                           \"tr_key\"\"005930\"\n" +
                "                  }\n" +
                "         }\n" +
                "}";
        this.userSession = userSession;
        sendMessage(requestMessage);


    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("closing websocket");
        this.userSession = null;
    }

    public void addMessageHandler(MessageHandler msgHandler) {
        this.messageHandler = msgHandler;
    }


    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);    //입력된 메시지 서버로 전송
    }

    public static interface MessageHandler {
        public void handleMessage(String message) throws ParseException, IOException;
    }

}

//        // JSON 요청 메시지 생성
//        JSONObject requestMessage = new JSONObject();
//
//        // Header 객체 생성
//        JSONObject header = new JSONObject();
//        header.put("approval_key", "f26c2cf7-d2ef-4f94-8ff5-4b1d089072cb");
//        header.put("custtype", "P");
//        header.put("tr_type", "1");
//        header.put("content-type", "utf-8");
//
//        // Body 객체 생성
//        JSONObject body = new JSONObject();
//
//        // Input 객체 생성
//        JSONObject input = new JSONObject();
//        input.put("tr_id", "H0STCNT0");
//        input.put("tr_key", "086520");
//
//        // Body에 Input 객체 추가
//        body.put("input", input);
//
//        // Header와 Body를 요청 메시지에 추가
//        requestMessage.put("header", header);
//        requestMessage.put("body", body);
//
//        // JSON 문자열로 변환
//        String requestMessageStr = requestMessage.toString();
//
//        this.userSession = userSession;
//        sendMessage(requestMessageStr);
//    }