package com.example.visionarycrofting.Services;

import com.example.visionarycrofting.Entities.Stock;

import java.util.List;

public interface IStockService {

    public Stock saveStock(Stock stock);

    public Stock findByEmail(String email);

    public Stock updateStock(Stock stock);

    public Stock findOneStock(Long id);

    public List<Stock> getAllStock();

    public Stock findByTelephone(String telephone);

    boolean loginStock(String email, String password);
}
