package com.example.visionarycroftingspring_security.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock extends UserApp {

    @OneToMany(mappedBy = "stock" ,fetch = FetchType.LAZY)
    private List<Produit> produits = new ArrayList<>();

    @OneToMany(mappedBy = "stock",fetch = FetchType.LAZY)
    private List<AppelOffre> appeleOffres = new ArrayList<>();

    public Stock(Long id, String nom, String email, String password, String telephone, String adresse, List<Produit> produits) {
        super(id, nom, email, password, telephone, adresse);
        this.produits = produits;
    }

    public Stock() {
    }

@JsonIgnore
    public List<Produit> getProduits() {
        return produits;
    }
@JsonSetter
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
@JsonIgnore
    public List<AppelOffre> getAppeleOffres() {
        return appeleOffres;
    }
@JsonSetter
    public void setAppeleOffres(List<AppelOffre> appeleOffres) {
        this.appeleOffres = appeleOffres;
    }

}
