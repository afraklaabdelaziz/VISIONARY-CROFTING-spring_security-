package com.example.visionarycrofting.Services;

import com.example.visionarycrofting.Entities.Commande;
import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Entities.StatusCommande;

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
