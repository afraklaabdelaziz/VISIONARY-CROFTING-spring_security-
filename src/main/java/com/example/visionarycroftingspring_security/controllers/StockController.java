package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.*;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IAppelOffreService;
import com.example.visionarycroftingspring_security.services.IProduitService;
import com.example.visionarycroftingspring_security.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    IStockService stockService;
    @Autowired
    IProduitService produitService;
    @Autowired
    IAppelOffreService appelOffreService;

    @PostMapping("/login")
    public ResponseDTO loginClient(@RequestBody String email , @RequestBody String password){
        return stockService.loginStock(email,password);
    }

    @PostMapping("/register")
    public ResponseDTO registerClient(@Valid @RequestBody Stock stock, BindingResult result){
        return  stockService.saveStock(stock);
    }

}
