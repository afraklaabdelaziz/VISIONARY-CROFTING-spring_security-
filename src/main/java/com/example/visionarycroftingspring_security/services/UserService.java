package com.example.visionarycroftingspring_security.services;


import com.example.visionarycroftingspring_security.entities.UserApp;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    ResponseDTO addUser(UserApp userApp);
    UserDetails findByEmail(String email);
    UserApp findByTelephone(String telephone);
}
