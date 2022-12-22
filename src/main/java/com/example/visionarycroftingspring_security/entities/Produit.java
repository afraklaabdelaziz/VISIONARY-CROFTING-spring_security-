package com.example.visionarycroftingspring_security.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String nom;
    private Double prixInitial;
    private String description;
    private Integer quantity;
    private Category category;
    @ManyToOne
    private Stock stock;

    @OneToMany (mappedBy = "produit")
    private List<CommandeItem> commandeItems = new ArrayList<>();

    public Produit(String reference, String nom, Double prixInitial, String description, Integer quantity, Category category, Stock stock, List<CommandeItem> commandeItems) {
        this.reference = reference;
        this.nom = nom;
        this.prixInitial = prixInitial;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
        this.stock = stock;
        this.commandeItems = commandeItems;
    }

    public Produit() {
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(Double prixInitial) {
        this.prixInitial = prixInitial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
     @JsonIgnore
    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }
     @JsonSetter
    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", nom='" + nom + '\'' +
                ", prixInitial=" + prixInitial +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}
