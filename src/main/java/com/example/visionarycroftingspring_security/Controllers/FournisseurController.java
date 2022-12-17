package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.Fournisseur;
import com.example.visionarycroftingspring_security.Entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.Services.IAppelOffreService;
import com.example.visionarycroftingspring_security.Services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("fournisseur")
public class FournisseurController {
    @Autowired
    IFournisseurService fournisseurService;
    @Autowired
    IAppelOffreService appelOffreService;
    @GetMapping("/login")
    public String login(){
        return "loginClient";
    }
    @PostMapping("/login")
    public String loginClient(@ModelAttribute Fournisseur fournisseur , Model model, HttpSession session){
        session.setAttribute("fournisseur",fournisseurService.findByEmail(fournisseur.getEmail()));
        if(fournisseurService.loginFournisseur(fournisseur.getEmail(),fournisseur.getPassword())){

            return "redirect:allappeloffres";
        }else {
            model.addAttribute("error","mot de pass ou email es incorrect ");
            return "loginClient";
        }

    }
    @GetMapping("/register")
    public String register(){
        return "registerFournisseur";
    }
    @PostMapping("/register")
    public String registerClient(@ModelAttribute Fournisseur fournisseur, BindingResult result,Model model){
        if (result.hasErrors() || fournisseurService.saveFornisseur(fournisseur) == null ){
            model.addAttribute("error","merci de compliter votre information");
            return "registerFournisseur";
        }
        fournisseurService.saveFornisseur(fournisseur);
        return "redirect:login";
    }
    @GetMapping("/allappeloffres")
    public String AllappelOffre(Model model){
        model.addAttribute("appelOffres",appelOffreService.findByStatusAppelOffre(StatusAppelOffre.OUVERTE));
        return "appelOffre";
    }
}
