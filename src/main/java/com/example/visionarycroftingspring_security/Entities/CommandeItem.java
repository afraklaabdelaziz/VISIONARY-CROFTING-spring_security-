package com.example.visionarycroftingspring_security.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;

@Entity
public class CommandeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(unique = true)
    private String reference;

    private Float prix;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Commande commande;

    @ManyToOne
    private Produit produit;

    public CommandeItem(String reference, Float prix, int quantity, Commande commande, Produit produit) {
        this.reference = reference;
        this.prix = prix;
        this.quantity = quantity;
        this.commande = commande;
        this.produit = produit;
    }

    public CommandeItem() {
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

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public Commande getCommande() {
        return commande;
    }
    @JsonSetter
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "CommandeItem{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", prix=" + prix +
                ", quantity=" + quantity +
                ", produit=" + produit +
                '}';
    }
}
