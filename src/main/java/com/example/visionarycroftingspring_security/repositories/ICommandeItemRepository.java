package com.example.visionarycroftingspring_security.repositories;

import com.example.visionarycroftingspring_security.entities.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommandeItemRepository extends JpaRepository<CommandeItem,Long> {
    public void deleteByReference(String reference);
    public CommandeItem findCommandeItemsByReference(String reference);
    List<CommandeItem> findCommandeItemsByQuantityGreaterThan(int quantity);
}
