package com.example.visionarycroftingspring_security.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @NotEmpty(message = "nom de client doit etre un valeur")
    @Size(min = 4,max = 20,message = "min est 4 max est 20")
    private String nom;
    @Column(unique = true)
    @NotEmpty(message = "email doit etre in value")
    @Email(message = "email doit etre sous format email")
    private String email;
    @NotEmpty(message = "password doit etre un value")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(unique = true)
    @NotEmpty(message = "telephone doit etre un value")
    private String telephone;
    @NotEmpty(message = "adresse doit etre un value")
    private String adresse;

    @ManyToOne
    private Role role;

    public UserApp(Long id, String nom, String email, String password, String telephone, String adresse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public UserApp() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
