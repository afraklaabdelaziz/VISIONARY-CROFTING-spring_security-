package com.example.visionarycroftingspring_security.services;


import com.example.visionarycroftingspring_security.entities.Commande;
import com.example.visionarycroftingspring_security.entities.CommandeItem;
import com.example.visionarycroftingspring_security.entities.StatusCommande;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;

import java.util.List;

public interface ICommandeService {
    ResponseDTO save(Commande commande);
    List<Commande> findAll();
    ResponseDTO findById(Long id);
    Commande findByReference(String ref);
    List<Commande> findEffectuedCommands();
    Commande updateCommandePrix(Commande commande);

    ResponseDTO updateCommande(Commande commande);

    void saveCommandeItems(Commande commande , List<CommandeItem> commandeItems);
    Commande getCommandeClientStatusEncours(Long idClient, StatusCommande status);
}
