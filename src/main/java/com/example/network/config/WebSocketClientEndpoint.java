package com.example.network.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
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

    /**
     * Callback hook for Connection open events.
     *
     * @param userSession the userSession which is opened.
     */
    @OnOpen
    public void onOpen(Session userSession, @PathParam("trKey") String trKey) {
        System.out.println("opening websocket");

        // JSON 객체를 생성
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode requestObject = objectMapper.createObjectNode();

        ObjectNode header = objectMapper.createObjectNode();
        header.put("approval_key", "bd69f1f9-014f-457d-af41-e5201fc971e3");
        header.put("custtype", "P");
        header.put("tr_type", "1");
        header.put("content-type", "utf-8");

        ObjectNode body = objectMapper.createObjectNode();
        ObjectNode input = objectMapper.createObjectNode();
        input.put("tr_id", "2167398");
        input.put("tr_key", trKey);

        input.set("input", input);
        requestObject.set("header", header);
        requestObject.set("body", body);

        String requestMessage = requestObject.toString();

        this.userSession = userSession;
        sendMessage(requestMessage);
    }


    /**
     * Callback hook for Connection close events.
     *
     * @param userSession the userSession which is getting closed.
     * @param reason the reason for connection close
     */
    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("closing websocket");
        this.userSession = null;
    }

    /**
     * Callback hook for Message Events. This method will be invoked when a client send a message.
     *
     * @param message The text message
     */
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

    /**
     * register message handler
     *
     * @param msgHandler
     */
    public void addMessageHandler(MessageHandler msgHandler) {
        this.messageHandler = msgHandler;
    }

    /**
     * Send a message.
     *
     * @param message
     */
    public void sendMessage(String message) {
        this.userSession.getAsyncRemote().sendText(message);    //입력된 메시지 서버로 전송
    }

    /**
     * Message handler.
     *
     * @author Jiji_Sasidharan
     */
    public static interface MessageHandler {
        public void handleMessage(String message) throws ParseException, IOException;
    }

}