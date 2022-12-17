package com.example.visionarycroftingspring_security.Repositories;

import com.example.visionarycroftingspring_security.Entities.Client;
import com.example.visionarycroftingspring_security.Entities.Commande;
import com.example.visionarycroftingspring_security.Entities.StatusCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommandeRepository extends JpaRepository<Commande,Long> {
    Commande findCommandeByReference(String reference);

    List<Commande> findCommandesByStatusAndClient(StatusCommande status, Client client);

    @Query("select c from Commande  c where c.client.id = :id and c.status = :status")
    public Commande getCommadeClient(Long id, StatusCommande status);

    @Query("select c FROM Commande c where c.prixTotal>:val")
    public List<Commande> getCommandes(Long val);
}
