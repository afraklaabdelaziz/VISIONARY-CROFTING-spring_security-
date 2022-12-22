package com.example.visionarycroftingspring_security.controllers;

import com.example.visionarycroftingspring_security.config.JwtUtils;
import com.example.visionarycroftingspring_security.entities.UserApp;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.UserService;
import com.example.visionarycroftingspring_security.dto.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/authenticate")
public class AuthController {
@Autowired
AuthenticationManager authenticationManager;
@Autowired
    UserService userService;
@Autowired
    JwtUtils jwtUtils;

@PostMapping("/register")
public ResponseDTO register(@Valid @RequestBody UserApp user){
    return userService.addUser(user);
}

@PostMapping("/login")
    public ResponseEntity<String> auth(@RequestBody AuthenticationRequest request){
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
     UserDetails user = userService.findByEmail(request.getEmail());
     if (user != null){
         return ResponseEntity.ok(jwtUtils.generateToken(user));
     }
     return ResponseEntity.status(400).body("error");
    }
}
