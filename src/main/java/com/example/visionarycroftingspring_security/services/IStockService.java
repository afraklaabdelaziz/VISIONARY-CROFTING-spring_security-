package com.example.visionarycroftingspring_security.services;


import com.example.visionarycroftingspring_security.entities.Stock;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;

import java.util.List;

public interface IStockService {

    public ResponseDTO saveStock(Stock stock);

    public Stock findByEmail(String email);

    public Stock updateStock(Stock stock);

    public Stock findOneStock(Long id);

    public List<Stock> getAllStock();

    public Stock findByTelephone(String telephone);

    ResponseDTO loginStock(String email, String password);
}
