package com.example.visionarycroftingspring_security.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client extends UserApp {

    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY)
    private List<Commande> commandes ;

    public Client(Long id, String nom, String email, String password, String telephone, String adresse, List<Commande> commandes) {
        super(id, nom, email, password, telephone, adresse);
        this.commandes = commandes;
    }


    public Client() {

    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

}
