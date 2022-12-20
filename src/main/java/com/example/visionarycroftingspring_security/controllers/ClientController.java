package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.entities.Client;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService clientService;

    @PostMapping("/login")
    public ResponseDTO loginClient(@RequestBody String email, @RequestBody String password){
               return clientService.loginClient(email, password);
    }

    @PostMapping("/register")
    public ResponseDTO registerClient(@RequestBody Client client) {
        return clientService.save(client);
    }
}
