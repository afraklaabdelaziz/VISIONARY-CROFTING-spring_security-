package com.example.visionarycroftingspring_security.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Fournisseur extends UserApp {

    @OneToMany(mappedBy = "fournisseur")
    private List<AppelOffre> appelOffres;

    public Fournisseur(Long id, String nom, String email, String password, String telephone, String adresse, List<AppelOffre> appelOffres) {
        super(id, nom, email, password, telephone, adresse);
        this.appelOffres = appelOffres;
    }


    public Fournisseur() {
    }

@JsonIgnore
    public List<AppelOffre> getAppelOffres() {
        return appelOffres;
    }
@JsonSetter
    public void setAppelOffres(List<AppelOffre> appelOffres) {
        this.appelOffres = appelOffres;
    }

}
