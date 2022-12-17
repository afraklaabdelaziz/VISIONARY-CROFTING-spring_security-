package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Services.IClientService;
import com.example.visionarycrofting.Services.IFournisseurService;
import com.example.visionarycrofting.Services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AutentificationController {
    @Autowired
    IStockService stockService;

    @Autowired
    IFournisseurService fornisseurService;


}
