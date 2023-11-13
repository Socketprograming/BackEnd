package com.example.network.config;

import jakarta.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.text.ParseException;

@ClientEndpoint
public class WebSocketClientEndpoint {

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
                "                  \"approval_key\": \"fa3c955a-3e06-4927-82a6-ddbfe9da8472\",\n" +
                "                  \"custtype\":\"P\",\n" +
                "                  \"tr_type\":\"1\",\n" +
                "                  \"content-type\":\"utf-8\"\n" +
                "         },\n" +
                "         \"body\":\n" +
                "         {\n" +
                "                  \"input\":\n" +
                "                  {\n" +
                "                           \"tr_id\":\"H0STCNT0\",\n" +
                "                           \"tr_key\":\"005930\"\n" +
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

    @OnMessage
    public void onMessage(String message) throws ParseException, IOException {
        if (this.messageHandler != null) {
            this.messageHandler.handleMessage(message);
        }
    }

    @OnMessage
    public void onMessage(ByteBuffer bytes) {
        System.out.println("Handle byte buffer");
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