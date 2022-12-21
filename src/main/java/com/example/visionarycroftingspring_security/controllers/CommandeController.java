package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.Commande;
import com.example.visionarycroftingspring_security.services.ICommandeService;
import com.example.visionarycroftingspring_security.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/commande")
public class CommandeController {
    @Autowired
    ICommandeService commandeService;
    @Autowired
    IProduitService produitService;
    @PostMapping("/update")
    public Object updateCommande(@RequestBody Commande commande){
        if (commandeService.updateCommande(commande) == null){
            return null;
        }else {
            commandeService.updateCommande(commande);
            return null;
        }

    }
}
