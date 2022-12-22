package com.example.visionarycroftingspring_security.services.Impl;

import com.example.visionarycroftingspring_security.entities.UserApp;
import com.example.visionarycroftingspring_security.repositories.UserRepository;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseDTO addUser(UserApp userApp) {
        if (userApp == null ){
            return new ResponseDTO("Bad request","ce user est null");
        }else if(userApp.getNom() == null || userApp.getPassword() == null
                || userApp.getTelephone() == null || userApp.getEmail() == null){
            return new ResponseDTO("Bad request","compliter les information de user");
        }else if (userRepository.findByEmail(userApp.getEmail()) != null || userRepository.findByTelephone(userApp.getTelephone()) != null ){
            return new ResponseDTO("Bad request","ce user a deja existe");
        }else {
            userApp.setPassword(new BCryptPasswordEncoder().encode(userApp.getPassword()));
            userRepository.save(userApp);
            return new ResponseDTO("200","votre compte a ete cree avec success",userApp);
        }
    }


    @Override
    public UserDetails findByEmail(String email){
       UserApp userApp = userRepository.findByEmail(email);
       return new User(userApp.getEmail(),userApp.getPassword(),Collections.singleton(new SimpleGrantedAuthority(userApp.getRole().getNom())));
    }

    @Override
    public UserApp findByTelephone(String telephone) {
        return userRepository.findByTelephone(telephone);
    }
}
