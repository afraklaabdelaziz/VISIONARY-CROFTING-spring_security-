package com.example.visionarycroftingspring_security.Services.Impl;

import com.example.visionarycroftingspring_security.Entities.Stock;
import com.example.visionarycroftingspring_security.Repositories.IStockRepository;
import com.example.visionarycroftingspring_security.Services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockImpl implements IStockService {
    @Autowired
    IStockRepository stockRepository;
    @Override
    public Stock saveStock(Stock stock) {
        if (stock == null ){
            return null;
        }else if(stock.getNom() == null || stock.getPassword() == null
                || stock.getTelephone() == null || stock.getEmail() == null){
            return null;
        }else if (stockRepository.findByEmail(stock.getEmail()) != null || stockRepository.findByTelephone(stock.getTelephone()) != null ){
            System.out.println("this client already exist");
            return null;
        }else {
            return stockRepository.save(stock);
        }
    }

    @Override
    public Stock findByEmail(String email) {
        return stockRepository.findByEmail(email);
    }

    @Override
    public Stock updateStock(Stock stock) {
        return null;
    }

    @Override
    public Stock findOneStock(Long id) {
        return null;
    }

    @Override
    public List<Stock> getAllStock() {
        return null;
    }

    @Override
    public Stock findByTelephone(String telephone) {
        return stockRepository.findByTelephone(telephone);
    }

    @Override
    public boolean loginStock(String email, String password) {
        Stock stock = stockRepository.findByEmail(email);
        if(stock == null){
            return false;
        }else if(stock.getEmail().equals(email) && stock.getPassword().equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
