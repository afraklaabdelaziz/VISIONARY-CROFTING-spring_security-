package com.example.visionarycroftingspring_security.Controllers;

import com.example.visionarycroftingspring_security.Entities.Client;
import com.example.visionarycroftingspring_security.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService clientService;

    @PostMapping("/login")
    public boolean loginClient(@RequestBody String email,@RequestBody String password){
               return clientService.loginClient(email, password);
    }

    @PostMapping("/register")
    public Client registerClient(@RequestBody Client client) {
        return clientService.save(client);
    }
}
