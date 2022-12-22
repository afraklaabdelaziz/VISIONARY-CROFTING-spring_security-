package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.Commande;
import com.example.visionarycroftingspring_security.entities.CommandeItem;
import com.example.visionarycroftingspring_security.entities.StatusCommande;
import com.example.visionarycroftingspring_security.services.IClientService;
import com.example.visionarycroftingspring_security.services.ICommandeItemService;
import com.example.visionarycroftingspring_security.services.ICommandeService;
import com.example.visionarycroftingspring_security.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
public class CommandeItemController {

    @Autowired
    ICommandeItemService commandeItemService;
    @Autowired
    ICommandeService commandeService;
    @Autowired
    IProduitService produitService;
    @Autowired
    IClientService clientService;

    @PostMapping("/commandeitem/add/{idClient}")
    public CommandeItem addCommandeItem(@RequestBody CommandeItem commandeItem,@PathVariable Long idClient){
        return commandeItemService.save(commandeItem,idClient);
    }

    @GetMapping("/cart/{idClient}")
    public List<CommandeItem> allCommandeItems (@PathVariable Long idClient) {
        Commande commandeFind = commandeService.getCommandeClientStatusEncours(idClient, StatusCommande.EN_COURS);
            return commandeFind.getCommandeItems();
    }
    @DeleteMapping("/commandeitem/delete/{ref}")
    public void deleteCommandeItem(@PathVariable String ref){
        commandeItemService.deleteByRef(ref);
    }


}
