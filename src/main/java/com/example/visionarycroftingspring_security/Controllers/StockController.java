package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.*;
import com.example.visionarycrofting.Services.IAppelOffreService;
import com.example.visionarycrofting.Services.IProduitService;
import com.example.visionarycrofting.Services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    IStockService stockService;
    @Autowired
    IProduitService produitService;
    @Autowired
    IAppelOffreService appelOffreService;
    @GetMapping("/allproduit")
    public String allProduits(Model model,HttpSession session,@PathParam("category") Category category,@PathParam("price") String price){
        Stock stock = (Stock) session.getAttribute("stock");
        if (price != null){
           String min = "";
            String max = "";
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(price);
            while(m.find()) {
                min = max;
                max = m.group();
            }
            model.addAttribute("produits",produitService.findProduitByPrixInitialBetweenStock(stock,  Double.parseDouble(min), Double.parseDouble(max)));
        }

        else if (category != null){
            model.addAttribute("produits",produitService.findProuitsByCategoryAndStock(stock,category));
        }else {
            model.addAttribute("produits",produitService.findByStock(stock));
        }
        model.addAttribute("category", Category.values());
        return "produitsStock";
    }
    @PostMapping("/produits/add")
    public String addProduit(@ModelAttribute Produit produit){
        produitService.addProduit(produit);
        return "redirect:/stock/allproduit";
    }

    @PostMapping("/appelOffre/add")
    public String addAppelOffre(@ModelAttribute AppelOffre appelOffre){
        appelOffre.setStatusAppelOffre(StatusAppelOffre.OUVERTE);
        appelOffreService.addAppelOffre(appelOffre);
        return "redirect:/stock/allproduit";
    }

    @GetMapping("/login")
    public String login(){
        return "loginClient";
    }

    @PostMapping("/login")
    public String loginClient(@ModelAttribute Stock stock , Model model, HttpSession session){
        session.setAttribute("stock",stockService.findByEmail(stock.getEmail()));
        if(stockService.loginStock(stock.getEmail(),stock.getPassword())){

            return "redirect:allproduit";
        }else {
            model.addAttribute("error","mot de pass ou email es incorrect ");
            return "loginClient";
        }

    }
    @GetMapping("/mesappelsoffre")
    public String mesAppelsOffres(Model model, HttpSession session){
        Stock stock = (Stock) session.getAttribute("stock");
        model.addAttribute("appelOffres",appelOffreService.findAppelOffrsByStock(stock));
        return "appelsOffreStock";
    }
    @GetMapping("/register")
    public String register(){
        return "registerStock";
    }
    @PostMapping("/register")
    public String registerClient(@Valid @ModelAttribute Stock stock,Model model, BindingResult result){
        if (result.hasErrors() || stockService.saveStock(stock) == null){
            model.addAttribute("error","merci de compliter votre information");
            return "registerStock";
        }
            stockService.saveStock(stock);
            return "redirect:login";
    }

}
