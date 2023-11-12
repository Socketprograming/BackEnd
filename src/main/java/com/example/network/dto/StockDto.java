package com.example.network.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {
    private String stockCode;
    private String lastPrice;
//    private String rate;

}
