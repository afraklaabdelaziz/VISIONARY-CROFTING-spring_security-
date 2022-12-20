package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.Commande;
import com.example.visionarycroftingspring_security.entities.CommandeItem;
import com.example.visionarycroftingspring_security.entities.StatusCommande;
import com.example.visionarycroftingspring_security.services.IClientService;
import com.example.visionarycroftingspring_security.services.ICommandeItemService;
import com.example.visionarycroftingspring_security.services.ICommandeService;
import com.example.visionarycroftingspring_security.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public String addCommandeItem(@RequestBody CommandeItem commandeItem,@PathVariable Long idClient){
        commandeItemService.save(commandeItem,idClient);
        return "redirect:/produits";
    }

    @GetMapping("/cart/{idClient}")
    public List<CommandeItem> allCommandeItems (@PathVariable Long idClient) {
        Commande commandeFind = commandeService.getCommandeClientStatusEncours(idClient, StatusCommande.EN_COURS);
            return commandeFind.getCommandeItems();
    }
    @GetMapping("/commandeitem/delete/{ref}")
    public void deleteCommandeItem(@PathVariable String ref){
        commandeItemService.deleteByRef(ref);
    }


}
