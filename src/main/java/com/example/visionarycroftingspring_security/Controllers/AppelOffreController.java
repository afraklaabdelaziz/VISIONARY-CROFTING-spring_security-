package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.AppelOffre;
import com.example.visionarycroftingspring_security.Entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.Entities.Stock;
import com.example.visionarycroftingspring_security.Services.IAppelOffreService;
import com.example.visionarycroftingspring_security.Services.IProduitService;
import com.example.visionarycroftingspring_security.Services.IStockService;
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
    public AppelOffre appelOffre(@RequestBody AppelOffre appelOffre){
       return appelOffreService.updateAppelOffre(appelOffre);
    }

    @PostMapping("/add")
    public AppelOffre addAppelOffre(@RequestBody AppelOffre appelOffre){
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
