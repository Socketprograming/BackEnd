package com.example.network.service;

import com.example.network.entity.Stock;
import com.example.network.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

}
