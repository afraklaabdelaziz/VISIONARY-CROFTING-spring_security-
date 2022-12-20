package com.example.visionarycroftingspring_security.services.Impl;

import com.example.visionarycrofting.Utiles.GenerateReference;
import com.example.visionarycroftingspring_security.entities.AppelOffre;
import com.example.visionarycroftingspring_security.entities.Produit;
import com.example.visionarycroftingspring_security.entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.entities.Stock;
import com.example.visionarycroftingspring_security.repositories.IAppelOffreRepository;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IAppelOffreService;
import com.example.visionarycroftingspring_security.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AppelOffreImpl implements IAppelOffreService {
    @Autowired
    IAppelOffreRepository appelOffreRepository;
    @Autowired
    IProduitService produitService;
    @Override
    public List<AppelOffre> getAppelOffres() {
        return appelOffreRepository.findAll();
    }

    @Override
    public ResponseDTO addAppelOffre(AppelOffre appelOffre) {
        if (appelOffre == null){
            return new ResponseDTO("Bad request","appel offre est null");
        }else if(appelOffre.getProduit() == null || appelOffre.getQuantity() <=0){
            return new ResponseDTO("Bad request","compliter les information d'apple offre");
        }else {
            appelOffre.setReference(GenerateReference.applyGenerateReference());
            appelOffreRepository.save(appelOffre);
            return new ResponseDTO("200","votre apple offre a ete cree avec success",appelOffre);
        }

    }

    @Override
    public boolean deleteAppelOffre(Long id) {
         appelOffreRepository.deleteById(id);
        return true;
    }

    @Override
    public ResponseDTO updateAppelOffre(AppelOffre appelOffre) {
        if (appelOffre == null){
            return new ResponseDTO("Bad request","appel offre est null");
        }else {
            appelOffre.setStatusAppelOffre(StatusAppelOffre.VALIDE);
            Produit produit = produitService.getProduitById(appelOffre.getProduit().getId());
            produit.setQuantity(produit.getQuantity() + appelOffre.getQuantity());
            produitService.addProduit(produit);
            appelOffreRepository.save(appelOffre);
            return new ResponseDTO("200","appel offre est modifier avc success",appelOffre);
        }
    }

    @Override
    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre) {
        return appelOffreRepository.findByStatusAppelOffre(statusAppelOffre);
    }

    @Override
    public List<AppelOffre> findAppelOffrsByStock(Stock stock) {
        return appelOffreRepository.findAppelOffreByStock(stock);
    }


    @Override
    public Optional<AppelOffre> findById(Long id) {
        return Optional.empty();
    }
}
