package com.example.network.config;

import jakarta.websocket.Session;
import org.apache.tomcat.util.json.JSONParser;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
//import javax.json.Json;

public class TestApp {
    public static void main(String[] args) {

        try {
            // open websocket
            final WebSocketClientEndpoint clientEndPoint = new WebSocketClientEndpoint(new URI("ws://ops.koreainvestment.com:21000"));

            // add listener
            clientEndPoint.addMessageHandler(new WebSocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println(message);
                }
            });

            // send message to websocket
            clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");

            // wait 5 seconds for messages from websocket
            Thread.sleep(5000);

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }


}