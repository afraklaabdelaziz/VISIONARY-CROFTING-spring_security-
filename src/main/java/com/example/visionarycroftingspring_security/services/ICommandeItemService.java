package com.example.visionarycroftingspring_security.services;


import com.example.visionarycroftingspring_security.entities.CommandeItem;

import java.util.List;

public interface ICommandeItemService {
    CommandeItem save(CommandeItem commandeItems, Long idClient);

    void deleteByRef(String ref);

    CommandeItem findByRef(String ref);

    List<CommandeItem> findAll();

    List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity);
}
