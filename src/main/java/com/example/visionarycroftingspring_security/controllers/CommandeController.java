package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.Commande;
import com.example.visionarycroftingspring_security.entities.StatusCommande;
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
    @PostMapping("/update/{idClient}")
    public Object updateCommande(@PathVariable Long idClient){
        Commande commande = commandeService.getCommandeClientStatusEncours(idClient, StatusCommande.EN_COURS);
        if (commandeService.updateCommande(commande) == null){
            return "this commande est null";
        }else {
            return commandeService.updateCommande(commande);
        }

    }
}
