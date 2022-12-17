package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Client;
import com.example.visionarycrofting.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService clientService;

    @GetMapping("/login")
    public String login(){
        return "loginClient";
    }
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
    public String registerClient(@Valid @ModelAttribute Client client, BindingResult result, Model model){
        if (result.hasErrors() || clientService.save(client) == null){
            model.addAttribute("error","merci de compliter votre information");
            return "registerClient";
        }
        clientService.save(client);
        return "redirect:login";
    }
}
