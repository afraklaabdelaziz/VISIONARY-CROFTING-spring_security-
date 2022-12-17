package com.example.visionarycroftingspring_security.Services;


import com.example.visionarycroftingspring_security.Entities.CommandeItem;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ICommandeItemService {
    CommandeItem save(CommandeItem commandeItems, HttpSession session);

    void deleteByRef(String ref);

    CommandeItem findByRef(String ref);

    List<CommandeItem> findAll();

    List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity);
}
