package com.example.visionarycrofting.Entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @NotEmpty(message = "nom doit etre un value")
    @Size(min = 4,max = 20 , message = "nom doit erte entre 4 et 20")
    private String nom;
    @Column(unique = true)
    @NotEmpty(message = "email doit etre un value")
    @Email(message = "email en format email")
    private String email;
    @Column(unique = true)
    @NotEmpty(message = "telephone doit etre un value")
    private String telephone;
    @NotEmpty(message = "password doit etre un value")
    @Size(min = 4,max = 20 , message = "password doit erte entre 4 et 20")
    private String password;

    @OneToMany(mappedBy = "fournisseur")
    private List<AppelOffre> appelOffres;

    public Fournisseur(String nom, String email, String telephone, String password, List<AppelOffre> appelOffres) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.appelOffres = appelOffres;
    }

    public Fournisseur() {
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

    public List<AppelOffre> getAppelOffres() {
        return appelOffres;
    }

    public void setAppelOffres(List<AppelOffre> appelOffres) {
        this.appelOffres = appelOffres;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", appelOffres=" + appelOffres +
                '}';
    }
}
