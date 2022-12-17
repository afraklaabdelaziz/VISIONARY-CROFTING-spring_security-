package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.Fournisseur;
import com.example.visionarycrofting.Repositories.IFournisseurRepository;
import com.example.visionarycrofting.Services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FournisseurImpl implements IFournisseurService {
    @Autowired
    IFournisseurRepository fournisseurRepository;
    @Override
    public Fournisseur saveFornisseur(Fournisseur fornisseur) {
        if (fornisseur == null ){
            return null;
        }else if(fornisseur.getNom() == null || fornisseur.getPassword() == null
                || fornisseur.getTelephone() == null || fornisseur.getEmail() == null){
            return null;
        }else if (fournisseurRepository.findByEmail(fornisseur.getEmail()) != null || fournisseurRepository.findByTelephone(fornisseur.getTelephone()) != null ){
            System.out.println("this client already exist");
            return null;
        }else {
            return fournisseurRepository.save(fornisseur);
        }
    }

    @Override
    public Fournisseur findByEmail(String email) {
        return fournisseurRepository.findByEmail(email);
    }

    @Override
    public List<Fournisseur> getAllFornisseurs() {
        return null;
    }

    @Override
    public Fournisseur findByTelephone(String telephone) {
        return null;
    }

    @Override
    public Fournisseur update(Fournisseur fournisseur) {
        return null;
    }

    @Override
    public boolean loginFournisseur(String email, String password) {
        Fournisseur  fournisseur = fournisseurRepository.findByEmail(email);
        if(fournisseur == null){
            return false;
        }else if(fournisseur.getEmail().equals(email) && fournisseur.getPassword().equals(password)){
            return true;
        }else {
            return false;

        }
    }
}
