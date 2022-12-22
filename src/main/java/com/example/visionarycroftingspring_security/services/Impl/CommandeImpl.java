package com.example.visionarycroftingspring_security.services.Impl;

import com.example.visionarycroftingspring_security.entities.Commande;
import com.example.visionarycroftingspring_security.entities.CommandeItem;
import com.example.visionarycroftingspring_security.entities.Produit;
import com.example.visionarycroftingspring_security.entities.StatusCommande;
import com.example.visionarycroftingspring_security.repositories.ICommandeRepository;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.ICommandeService;
import com.example.visionarycroftingspring_security.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeImpl implements ICommandeService {
    @Autowired
    ICommandeRepository commandeRepository;
    @Autowired
    IProduitService produitService;
    @Override
    public ResponseDTO save(Commande commande) {
        if (commande == null){
            return new ResponseDTO("Bad request","cette commande est null");
        }else if (commande.getClient() == null || commande.getReference().equals("")) {
            return new ResponseDTO("Bad request","les information de commande est incompler");
        }
        else {
            commande.setDate(LocalDate.now());
            commandeRepository.save(commande);
            return new ResponseDTO("200","votre commande a cree avec success",commande);
        }
    }


    @Override
    public List<Commande> findAll() {
        return null;
    }

    @Override
    public ResponseDTO findById(Long id) {
        if (id < 0){
            return new ResponseDTO("Bad request","cette commande n'existe pas");
        }
        Commande commande =  commandeRepository.findById(id).get();
        return new ResponseDTO("200","votre commande",commande);
    }

    @Override
    public Commande findByReference(String ref) {
        return commandeRepository.findCommandeByReference(ref);
    }

    @Override
    public List<Commande> findEffectuedCommands() {
        return null;
    }

    @Override
    public Commande updateCommandePrix(Commande commande) {
        return null;
    }

    @Override
    public ResponseDTO updateCommande(Commande commande) {
        if (commande == null){
            return new ResponseDTO("Bad request","cette commande est null");
        }else if (commande.getClient() == null || commande.getReference().equals("") || commande.getCommandeItems().size() <=0 ) {
            return new ResponseDTO("Bad request","compliter les information de commande");
        }
        else {
            List<CommandeItem> commandeItems = commande.getCommandeItems();
            Float prixTotale = 0F;
            for (CommandeItem commandeItem : commandeItems){
                Produit produit = produitService.getProduitById(commandeItem.getProduit().getId());
                prixTotale+=commandeItem.getPrix();
                if(produit.getQuantity() < commandeItem.getQuantity()){
                    return new ResponseDTO("Bad request","quantity de produit est insurfisant");
                }
                produit.setQuantity(produit.getQuantity() - commandeItem.getQuantity());
                produitService.updateProduitQuantity(produit);
            }
            commande.setStatus(StatusCommande.EFFECTUER);
            commande.setDate(LocalDate.now());
            commande.setPrixTotal(prixTotale);
            commandeRepository.save(commande);
            return new ResponseDTO("200","commande est valider avec success",commande);
        }
    }

    @Override
    public void saveCommandeItems(Commande commande, List<CommandeItem> commandeItems) {

    }

    @Override
    public Commande getCommandeClientStatusEncours(Long idClient, StatusCommande status) {
        return commandeRepository.getCommadeClient(idClient,status);
    }
}
