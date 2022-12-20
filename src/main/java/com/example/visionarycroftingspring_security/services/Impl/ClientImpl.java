package com.example.visionarycroftingspring_security.services.Impl;

import com.example.visionarycroftingspring_security.entities.Client;
import com.example.visionarycroftingspring_security.repositories.IClientRepository;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientImpl implements IClientService {
    @Autowired
    IClientRepository clientRepository;
    @Override
    public ResponseDTO save(Client client) {
        if (client == null ){
            return new ResponseDTO("Bad request","ce client est null");
        }else if(client.getNom() == null || client.getPassword() == null
        || client.getTelephone() == null || client.getEmail() == null){
            return new ResponseDTO("Bad request","compliter les information");
        }else if (clientRepository.findByEmail(client.getEmail()) != null || clientRepository.findByTelephone(client.getTelephone()) != null ){
            return new ResponseDTO("Bad request","ce client deja existe ");
        }else {
            return new ResponseDTO("200","votre compte a ete cree avec success",client);
        }

    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public ResponseDTO loginClient(String email, String password) {
        Client client = clientRepository.findByEmail(email);
        if(client == null){
            return new ResponseDTO("Bad request","ce client est null");
        }else if(client.getEmail().equals(email) && client.getPassword().equals(password)){
            return new ResponseDTO("200","bienvenu sur votre compte",client);
        }else {
            return new ResponseDTO("Bad request","ce client n'existe pas s'il vous plait cree votre compte");
        }
    }
}
