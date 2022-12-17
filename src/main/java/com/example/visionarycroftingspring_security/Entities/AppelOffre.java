package com.example.visionarycrofting.Entities;

import javax.persistence.*;

@Entity
public class AppelOffre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private StatusAppelOffre statusAppelOffre;
    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Stock stock;

    @ManyToOne
    private Fournisseur fournisseur;

    public AppelOffre(String reference, StatusAppelOffre statusAppelOffre, Produit produit, Stock stock, Fournisseur fournisseur) {
        this.reference = reference;
        this.statusAppelOffre = statusAppelOffre;
        this.produit = produit;
        this.stock = stock;
        this.fournisseur = fournisseur;
    }

    public AppelOffre() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StatusAppelOffre getStatusAppelOffre() {
        return statusAppelOffre;
    }

    public void setStatusAppelOffre(StatusAppelOffre statusAppelOffre) {
        this.statusAppelOffre = statusAppelOffre;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "AppelOffre{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", quantity=" + quantity +
                ", statusAppelOffre=" + statusAppelOffre +
                ", produit=" + produit +
                ", stock=" + stock +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
