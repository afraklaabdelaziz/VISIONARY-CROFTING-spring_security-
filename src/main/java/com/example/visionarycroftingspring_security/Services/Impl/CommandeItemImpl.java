package com.example.visionarycroftingspring_security.Services.Impl;

import com.example.visionarycrofting.Utiles.GenerateReference;
import com.example.visionarycroftingspring_security.Entities.Client;
import com.example.visionarycroftingspring_security.Entities.Commande;
import com.example.visionarycroftingspring_security.Entities.CommandeItem;
import com.example.visionarycroftingspring_security.Entities.StatusCommande;
import com.example.visionarycroftingspring_security.Repositories.ICommandeItemRepository;
import com.example.visionarycroftingspring_security.Services.IClientService;
import com.example.visionarycroftingspring_security.Services.ICommandeItemService;
import com.example.visionarycroftingspring_security.Services.ICommandeService;
import com.example.visionarycroftingspring_security.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
public class CommandeItemImpl implements ICommandeItemService {

    @Autowired
    ICommandeItemRepository commandeItemRepository;
    @Autowired
    ICommandeService commandeService;
    @Autowired
    IProduitService produitService;
    @Autowired
    IClientService clientService;


    @Override
    public CommandeItem save(CommandeItem commandeItem, Long idClient) {
        Client client = clientService.findById(idClient).get();
        Commande commandeFind = commandeService.getCommandeClientStatusEncours(idClient, StatusCommande.EN_COURS);
        CommandeItem commandeItemFind = this.findByRef("2R5JX63V");
        if(commandeFind != null){
            commandeItem.setCommande(commandeFind);
        }else {
            Commande commande = new Commande();
            commande.setReference(GenerateReference.applyGenerateReference());
            commande.setClient(client);
            commande.setDate(LocalDate.now());
            commande.setPrixTotal(0F);
            commande.setStatus(StatusCommande.EN_COURS);
            commandeService.save(commande);
            commandeItem.setCommande(commande);
        }
        if(commandeItemFind != null && commandeFind != null){
            commandeItemFind.setQuantity(commandeItem.getQuantity()+ commandeItemFind.getQuantity());
            commandeItemFind.setPrix(commandeItemFind.getPrix()* commandeItemFind.getQuantity());
            commandeItemRepository.save(commandeItemFind);
            return commandeItem;
        }else {
            commandeItem.setReference(GenerateReference.applyGenerateReference());
            commandeItemRepository.save(commandeItem);
            return commandeItem;
        }


    }

    @Override
    @Transactional
    public void deleteByRef(String ref) {
        if (ref != null || !ref.isEmpty())
            commandeItemRepository.deleteByReference(ref);
    }

    @Override
    public CommandeItem findByRef(String ref) {
        return commandeItemRepository.findCommandeItemsByReference(ref);
    }

    @Override
    public List<CommandeItem> findAll() {
        return commandeItemRepository.findAll();
    }

    @Override
    public List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity) {
        return null;
    }
}
