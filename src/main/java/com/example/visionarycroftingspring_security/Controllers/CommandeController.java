package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.Commande;
import com.example.visionarycroftingspring_security.Services.ICommandeService;
import com.example.visionarycroftingspring_security.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/commande")
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
