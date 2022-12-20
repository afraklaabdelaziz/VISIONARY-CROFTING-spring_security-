package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.Category;
import com.example.visionarycroftingspring_security.entities.Produit;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    IProduitService produitService;
    @GetMapping
    public List<Produit> allProduit(@PathParam("category") Category category, @PathParam("price") String price){

        if (price != null){
            String min = "";
            String max = "";
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(price);
            while(m.find()) {
                min = max;
                max = m.group();
            }
            return produitService.findProduitByPrixInitialBetween(Double.parseDouble(min), Double.parseDouble(max));
        }

        else if (category != null){
           return produitService.findProuitsByCategory(category);
        }else {
            return produitService.getAllProduits();
        }
    }



    @GetMapping("/produit/{id}")
    public Produit produit(@PathVariable Long id){
       return produitService.getProduitById(id);
    }

    @PostMapping("/add")
    public ResponseDTO addProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }
}
