package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.Client;
import com.example.visionarycroftingspring_security.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService clientService;

    @PostMapping("/login")
    public String loginClient(@ModelAttribute Client client , Model model, HttpSession session){
        session.setAttribute("client",clientService.findByEmail(client.getEmail()));
        if(clientService.loginClient(client.getEmail(),client.getPassword())){

            return "redirect:/produits";
        }else {
            model.addAttribute("error","mot de pass ou email es incorrect ");
            return "loginClient";
        }

    }
    @GetMapping("/register")
    public String register(){
        return "registerClient";
    }

    @PostMapping("/register")
    public String registerClient(@ModelAttribute Client client, BindingResult result, Model model){
        if (result.hasErrors() || clientService.save(client) == null){
            model.addAttribute("error","merci de compliter votre information");
            return "registerClient";
        }
        clientService.save(client);
        return "redirect:login";
    }
}
