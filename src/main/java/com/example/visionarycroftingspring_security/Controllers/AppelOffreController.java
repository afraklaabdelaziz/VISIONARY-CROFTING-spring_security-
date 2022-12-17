package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.AppelOffre;
import com.example.visionarycroftingspring_security.Services.IAppelOffreService;
import com.example.visionarycroftingspring_security.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appelOffre")
public class AppelOffreController {
    @Autowired
    IAppelOffreService appelOffreService;
    @Autowired
    IProduitService produitService;
    @PostMapping("/add")
    public AppelOffre appelOffre(@ModelAttribute AppelOffre appelOffre){
       return appelOffreService.updateAppelOffre(appelOffre);
    }
}
