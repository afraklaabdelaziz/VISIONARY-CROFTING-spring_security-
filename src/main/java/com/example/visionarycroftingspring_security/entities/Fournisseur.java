package com.example.visionarycroftingspring_security.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fournisseur extends UserApp {

    @OneToMany(mappedBy = "fournisseur")
    private List<AppelOffre> appelOffres;

    public Fournisseur(Long id, String nom, String email, String password, String telephone, String adresse, List<AppelOffre> appelOffres) {
        super(id, nom, email, password, telephone, adresse);
        this.appelOffres = appelOffres;
    }


    public Fournisseur() {
    }


   public List<AppelOffre> getAppelOffres() {
        return appelOffres;
    }

    public void setAppelOffres(List<AppelOffre> appelOffres) {
        this.appelOffres = appelOffres;
    }

}
