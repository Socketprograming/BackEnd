package com.example.network.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StockComponent {

    @Value("${url}")
    private String url;

    @Value("${port}")
    private int port;

    @Value("${appkey}")
    private String appKey;

    @Value("${appsecretekey}")
    private String appSecretKey;

    @Value("${personalseckey}")
    private String personalsecKey;

    @Value("${custype}")
    private String custType;

    @Value("${contenttype}")
    private String contentType;

    @Value("${htsid}")
    private String htsId;

    //stockCode는 입력 받을 수 있도록
}
