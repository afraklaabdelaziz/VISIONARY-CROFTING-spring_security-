package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.AppelOffre;
import com.example.visionarycroftingspring_security.entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.entities.Stock;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IAppelOffreService;
import com.example.visionarycroftingspring_security.services.IProduitService;
import com.example.visionarycroftingspring_security.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appelOffre")
public class AppelOffreController {
    @Autowired
    IAppelOffreService appelOffreService;
    @Autowired
    IProduitService produitService;
    @Autowired
    IStockService stockService;
    @PostMapping("/update")
    public ResponseDTO appelOffre(@RequestBody AppelOffre appelOffre){
       return appelOffreService.updateAppelOffre(appelOffre);
    }

    @PostMapping("/add")
    public ResponseDTO addAppelOffre(@RequestBody AppelOffre appelOffre){
        appelOffre.setStatusAppelOffre(StatusAppelOffre.OUVERTE);
        return appelOffreService.addAppelOffre(appelOffre);
    }

    @GetMapping("/all")
    public List<AppelOffre> AllappelOffre(){
    return appelOffreService.findByStatusAppelOffre(StatusAppelOffre.OUVERTE);
    }

    @GetMapping("/appelsoffrestock/{idStock}")
    public List<AppelOffre> mesAppelsOffres(@PathVariable Long idStock){
        Stock stock = stockService.findOneStock(idStock);
        return appelOffreService.findAppelOffrsByStock(stock);
    }

}
