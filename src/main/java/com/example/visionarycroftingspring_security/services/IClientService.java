package com.example.visionarycroftingspring_security.services;


import com.example.visionarycroftingspring_security.entities.Client;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    ResponseDTO save(Client client);
    List<Client> findAll();
    boolean deleteById(Long id);

    Optional<Client> findById(Long id);

    Client findByEmail(String email);

    ResponseDTO loginClient(String email, String password);

}
