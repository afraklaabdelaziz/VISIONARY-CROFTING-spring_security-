package com.example.visionarycroftingspring_security.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String reference;

    private LocalDate date;

    private Float prixTotal;

     @Enumerated(EnumType.STRING)
    private StatusCommande status ;

    @OneToMany(mappedBy = "commande")
    private List<CommandeItem> commandeItems = new ArrayList<>();

    @ManyToOne
    private Client client ;

    public Commande(String reference, LocalDate date, Float prixTotal, StatusCommande status, List<CommandeItem> commandeItems, Client client) {
        this.reference = reference;
        this.date = date;
        this.prixTotal = prixTotal;
        this.status = status;
        this.commandeItems = commandeItems;
        this.client = client;
    }

    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public StatusCommande getStatus() {
        return status;
    }

    public void setStatus(StatusCommande status) {
        this.status = status;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }
@JsonIgnore
    public Client getClient() {
        return client;
    }
@JsonSetter
    public void setClient(Client client) {
        this.client = client;
    }

}
