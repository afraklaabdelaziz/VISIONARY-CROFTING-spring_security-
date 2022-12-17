package com.example.visionarycroftingspring_security.Services;

import com.example.visionarycroftingspring_security.Entities.Fournisseur;

import java.util.List;

public interface IFournisseurService {
    public Fournisseur saveFornisseur(Fournisseur fornisseur);
    public Fournisseur findByEmail(String email);
    public List<Fournisseur> getAllFornisseurs();
    public Fournisseur findByTelephone(String telephone);
    public Fournisseur update(Fournisseur fournisseur);

    boolean loginFournisseur(String email, String password);
}
