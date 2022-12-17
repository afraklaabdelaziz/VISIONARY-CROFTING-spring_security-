package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.Fournisseur;
import com.example.visionarycroftingspring_security.Services.IAppelOffreService;
import com.example.visionarycroftingspring_security.Services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fournisseur")
public class FournisseurController {
    @Autowired
    IFournisseurService fournisseurService;
    @Autowired
    IAppelOffreService appelOffreService;

    @PostMapping("/login")
    public boolean loginClient(@RequestBody String email,@RequestBody String password){
        return fournisseurService.loginFournisseur(email,password);
    }

    @PostMapping("/register")
    public Fournisseur registerClient(@RequestBody Fournisseur fournisseur){
        return fournisseurService.saveFornisseur(fournisseur);
    }
}
