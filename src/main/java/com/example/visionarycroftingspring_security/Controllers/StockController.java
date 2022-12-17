package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.*;
import com.example.visionarycroftingspring_security.Services.IAppelOffreService;
import com.example.visionarycroftingspring_security.Services.IProduitService;
import com.example.visionarycroftingspring_security.Services.IStockService;
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
    public boolean loginClient(@RequestBody String email , @RequestBody String password){
        return stockService.loginStock(email,password);
    }

    @PostMapping("/register")
    public Stock registerClient(@Valid @RequestBody Stock stock, BindingResult result){
        return  stockService.saveStock(stock);
    }

}
