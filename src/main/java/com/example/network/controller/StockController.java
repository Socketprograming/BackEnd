package com.example.network.controller;


import com.example.network.config.WebSocketClientEndpoint;
import com.example.network.dto.StockDto;
import com.example.network.response.BaseResponse;
import com.example.network.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

//    @GetMapping("/search")
//    public CompletableFuture<BaseResponse<StockDto>> SearchStock(){
//        CompletableFuture<BaseResponse<StockDto>> future = new CompletableFuture<>();
//
//        try {
//            // open websocket
//            final WebSocketClientEndpoint clientEndPoint = new WebSocketClientEndpoint(new URI("ws://ops.koreainvestment.com:21000/tryitout/H0STCNT0"));
//
//            // add listener
//            clientEndPoint.addMessageHandler(new WebSocketClientEndpoint.MessageHandler() {
//                public void handleMessage(String message) {
//
//                    // Split the message using the '^' delimiter
//                    String[] parts = message.split("\\^");
//
//                    // Check if the array has enough elements
//                    if (parts.length >= 3) {
//                        // Access individual parts based on their position
//                        String stockCode = parts[0];
//                        String timestamp = parts[1];
//                        String lastPrice = parts[2];
//
//                        // Print or use the extracted values
//                        System.out.println("Stock Code: " + stockCode);
//                        System.out.println("Timestamp: " + timestamp);
//                        System.out.println("Last Price: " + lastPrice);
//                        // ... print or use other values as needed
//
//                        StockDto stockDtoReal = new StockDto();
//                        stockDtoReal.setStockCode(stockCode);
////                        stockDtoReal.setRate(rate);
//                        stockDtoReal.setLastPrice(lastPrice);
//                        future.complete(new BaseResponse<>(stockDtoReal));
//
//                    } else {
//                        System.err.println("Invalid message format: " + message);
//                    }
//                }
//            });
//
//            // send message to websocket
//            clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");
//
//            // wait 5 seconds for messages from websocket
////            while(true) {
//            Thread.sleep(5000);
////            }
//
//        } catch (InterruptedException ex) {
//            System.err.println("InterruptedException exception: " + ex.getMessage());
//        } catch (URISyntaxException ex) {
//            System.err.println("URISyntaxException exception: " + ex.getMessage());
//        }
//
//        return future;
//    }

}