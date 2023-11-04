package com.example.network.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //종목명
    private String itemName;

    //종목코드
    private int itemCode;

    //현재가
    private int stockPrice;

    //등락률
    private double rate;
}
