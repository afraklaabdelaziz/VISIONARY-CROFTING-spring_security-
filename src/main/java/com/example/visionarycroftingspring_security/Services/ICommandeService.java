package com.example.visionarycroftingspring_security.Services;


import com.example.visionarycroftingspring_security.Entities.Commande;
import com.example.visionarycroftingspring_security.Entities.CommandeItem;
import com.example.visionarycroftingspring_security.Entities.StatusCommande;

import java.util.List;

public interface ICommandeService {
    Commande save(Commande commande);
    List<Commande> findAll();
    Commande findById(Long id);
    Commande findByReference(String ref);
    List<Commande> findEffectuedCommands();
    Commande updateCommandePrix(Commande commande);

    Commande updateCommande(Commande commande);

    void saveCommandeItems(Commande commande , List<CommandeItem> commandeItems);
    Commande getCommandeClientStatusEncours(Long idClient, StatusCommande status);
}
