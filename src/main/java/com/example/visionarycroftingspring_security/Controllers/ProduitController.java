package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.Category;
import com.example.visionarycroftingspring_security.Entities.Produit;
import com.example.visionarycroftingspring_security.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    IProduitService produitService;
    @GetMapping
    public String allProduit(Model model, @PathParam("category") Category category, @PathParam("price") String price){

        if (price != null){
            String min = "";
            String max = "";
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(price);
            while(m.find()) {
                min = max;
                max = m.group();
            }
            model.addAttribute("produits",produitService.findProduitByPrixInitialBetween(Double.parseDouble(min), Double.parseDouble(max)));
        }

        else if (category != null){
            model.addAttribute("produits",produitService.findProuitsByCategory(category));
        }else {
            model.addAttribute("produits", produitService.getAllProduits());
        }
        model.addAttribute("category",Category.values());
        return "produits";
    }

    @GetMapping("/produit/{id}")
    public String produit(@PathVariable Long id, Model model){
        Produit produit = produitService.getProduitById(id);
        model.addAttribute("produit",produit);
        return "produit";
    }
}
