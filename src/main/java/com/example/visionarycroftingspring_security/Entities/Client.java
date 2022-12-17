package com.example.visionarycroftingspring_security.Entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "nom de client doit etre un valeur")
    @Size(min = 4,max = 20,message = "min est 4 max est 20")
    private String nom;
    @Column(unique = true)
    @NotEmpty(message = "email doit etre in value")
    @Email(message = "email doit etre sous format email")
    private String email;
    @Column(unique = true)
    @NotEmpty(message = "telephone doit etre un value")
    private String telephone;
    @NotEmpty(message = "password doit etre un value")
    @Size(min = 4,max = 20 , message = "password doit erte entre 4 et 20")
    private String password;

    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY)
    private List<Commande> commandes ;

    public Client(String nom, String email, String telephone, String password, List<Commande> commandes) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.commandes = commandes;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", commandes=" + commandes +
                '}';
    }
}
