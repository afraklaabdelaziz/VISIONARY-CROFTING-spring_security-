package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.Fournisseur;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IAppelOffreService;
import com.example.visionarycroftingspring_security.services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fournisseur")
public class FournisseurController {
    @Autowired
    IFournisseurService fournisseurService;

    @PostMapping("/login")
    public ResponseDTO loginClient(@RequestBody String email, @RequestBody String password){
        return fournisseurService.loginFournisseur(email,password);
    }

    @PostMapping("/register")
    public ResponseDTO registerClient(@RequestBody Fournisseur fournisseur){
        return fournisseurService.saveFornisseur(fournisseur);
    }
}
