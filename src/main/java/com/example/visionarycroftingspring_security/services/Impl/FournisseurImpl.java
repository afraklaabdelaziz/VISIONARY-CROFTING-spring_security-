package com.example.visionarycroftingspring_security.services.Impl;

import com.example.visionarycroftingspring_security.entities.Fournisseur;
import com.example.visionarycroftingspring_security.repositories.IFournisseurRepository;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FournisseurImpl implements IFournisseurService {
    @Autowired
    IFournisseurRepository fournisseurRepository;
    @Override
    public ResponseDTO saveFornisseur(Fournisseur fornisseur) {
        if (fornisseur == null ){
            return new ResponseDTO("Bad request","ce fournisseur est null");
        }else if(fornisseur.getNom() == null || fornisseur.getPassword() == null
                || fornisseur.getTelephone() == null || fornisseur.getEmail() == null){
            return new ResponseDTO("Bad request","compliter vote informatins");
        }else if (fournisseurRepository.findByEmail(fornisseur.getEmail()) != null || fournisseurRepository.findByTelephone(fornisseur.getTelephone()) != null ){
            return new ResponseDTO("Bad request","ce fournisseur deja existe");
        }else {
            return new ResponseDTO("200","votre commte a ete cree avec success",fornisseur);
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
    public ResponseDTO loginFournisseur(String email, String password) {
        Fournisseur  fournisseur = fournisseurRepository.findByEmail(email);
        if(fournisseur == null){
            return new ResponseDTO("Bad request","ce fournisseur est null");
        }else if(fournisseur.getEmail().equals(email) && fournisseur.getPassword().equals(password)){
            return new ResponseDTO("200","bienvenu sur vvotre compte",fournisseur);
        }else {
            return new ResponseDTO("Bad request","ce client n'existe pas s'il vous plait cree votre compte");

        }
    }
}
