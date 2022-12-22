package com.example.visionarycroftingspring_security.services;

import com.example.visionarycroftingspring_security.entities.Fournisseur;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;

import java.util.List;

public interface IFournisseurService {
    public ResponseDTO saveFornisseur(Fournisseur fornisseur);
    public Fournisseur findByEmail(String email);
    public List<Fournisseur> getAllFornisseurs();
    public Fournisseur findByTelephone(String telephone);
    public Fournisseur update(Fournisseur fournisseur);
    public Fournisseur findById(Long id);

    ResponseDTO loginFournisseur(String email, String password);
}
