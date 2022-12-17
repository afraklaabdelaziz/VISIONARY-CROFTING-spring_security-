package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.Client;
import com.example.visionarycroftingspring_security.Entities.Commande;
import com.example.visionarycroftingspring_security.Entities.CommandeItem;
import com.example.visionarycroftingspring_security.Entities.StatusCommande;
import com.example.visionarycroftingspring_security.Services.ICommandeItemService;
import com.example.visionarycroftingspring_security.Services.ICommandeService;
import com.example.visionarycroftingspring_security.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommandeItemController {
    @Autowired
    ICommandeItemService commandeItemService;
    @Autowired
    ICommandeService commandeService;
    @Autowired
    IProduitService produitService;
    @PostMapping("/commandeitem/add")
    public String addCommandeItem(@ModelAttribute CommandeItem commandeItem, HttpSession session){
        commandeItemService.save(commandeItem,session);
        return "redirect:/produits";
    }
    @GetMapping("/cart")
    public String allCommandeItems (Model model,HttpSession session){
        Client client = (Client) session.getAttribute("client");
        Commande commandeFind = commandeService.getCommandeClientStatusEncours(client.getId(), StatusCommande.EN_COURS);
        if (commandeFind != null){
             List<CommandeItem> commandeItems = commandeFind.getCommandeItems();
             Float prixTotal = 0F;
             for (CommandeItem commandeItem : commandeItems){
                 prixTotal+= (commandeItem.getPrix()*commandeItem.getQuantity());
             }
             model.addAttribute("commadeItems",commandeItems);
             model.addAttribute("idCommande",commandeFind.getId());
            model.addAttribute("referenceCommande",commandeFind.getReference());
             model.addAttribute("prixTotal",prixTotal);
        }
        return "cart";
    }

    @GetMapping("/commandeitem/delete/{ref}")
    public String deleteCommandeItem(@PathVariable String ref){
        commandeItemService.deleteByRef(ref);
        return "redirect:/cart";
    }


}
