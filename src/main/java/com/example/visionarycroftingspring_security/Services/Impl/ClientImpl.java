package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.Client;
import com.example.visionarycrofting.Repositories.IClientRepository;
import com.example.visionarycrofting.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientImpl implements IClientService {
    @Autowired
    IClientRepository clientRepository;
    @Override
    public Client save(Client client) {
        if (client == null ){
            return null;
        }else if(client.getNom() == null || client.getPassword() == null
        || client.getTelephone() == null || client.getEmail() == null){
            return null;
        }else if (clientRepository.findByEmail(client.getEmail()) != null || clientRepository.findByTelephone(client.getTelephone()) != null ){
            System.out.println("this client already exist");
            return null;
        }else {
            return clientRepository.save(client);
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
    public boolean loginClient(String email, String password) {
        Client client = clientRepository.findByEmail(email);
        if(client == null){
            return false;
        }else if(client.getEmail().equals(email) && client.getPassword().equals(password)){
            return true;
        }else {
            return false;

        }
    }
}
