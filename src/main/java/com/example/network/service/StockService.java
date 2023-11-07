package com.example.network.service;

import com.example.network.entity.Stock;
import com.example.network.repository.StockRepository;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    Stock stock = stockRepository.findAll().get(0);
    double SetPrice = stock.getStockPrice();
}
