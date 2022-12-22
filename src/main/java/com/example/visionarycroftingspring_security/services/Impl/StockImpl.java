package com.example.visionarycroftingspring_security.services.Impl;

import com.example.visionarycroftingspring_security.entities.Stock;
import com.example.visionarycroftingspring_security.repositories.IStockRepository;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockImpl implements IStockService {
    @Autowired
    IStockRepository stockRepository;
    @Override
    public ResponseDTO saveStock(Stock stock) {
        if (stock == null ){
            return new ResponseDTO("Bad request","ce stock est null");
        }else if(stock.getNom() == null || stock.getPassword() == null
                || stock.getTelephone() == null || stock.getEmail() == null){
            return new ResponseDTO("Bad request","compliter les information de stock");
        }else if (stockRepository.findByEmail(stock.getEmail()) != null || stockRepository.findByTelephone(stock.getTelephone()) != null ){
            return new ResponseDTO("Bad request","ce stock a deja existe");
        }else {
            return new ResponseDTO("200","votre commte a ete cree avec success",stock);
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
        return stockRepository.findById(id).get();
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
    public ResponseDTO loginStock(String email, String password) {
        Stock stock = stockRepository.findByEmail(email);
        if(stock == null){
            return new ResponseDTO("Bad request","ce stock est null");
        }else if(stock.getEmail().equals(email) && stock.getPassword().equals(password)){
            return new ResponseDTO("200","bienvenu sur votre compte",stock);
        }else {
            return new ResponseDTO("Bad request","ce client n'existe pas s'il vous plait cree votre compte");
        }
    }
}
