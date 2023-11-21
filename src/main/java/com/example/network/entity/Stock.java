package com.example.network.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //종목명
    private String itemName;

    //종목코드
    private String itemCode;

    //현재가
    @Getter
    private String stockPrice;

    //등락률
    private double rate;

}
