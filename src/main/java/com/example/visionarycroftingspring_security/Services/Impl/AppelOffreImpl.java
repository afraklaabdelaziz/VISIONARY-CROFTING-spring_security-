package com.example.visionarycroftingspring_security.Services.Impl;

import com.example.visionarycrofting.Utiles.GenerateReference;
import com.example.visionarycroftingspring_security.Entities.AppelOffre;
import com.example.visionarycroftingspring_security.Entities.Produit;
import com.example.visionarycroftingspring_security.Entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.Entities.Stock;
import com.example.visionarycroftingspring_security.Repositories.IAppelOffreRepository;
import com.example.visionarycroftingspring_security.Services.IAppelOffreService;
import com.example.visionarycroftingspring_security.Services.IProduitService;
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
    public AppelOffre addAppelOffre(AppelOffre appelOffre) {
        if (appelOffre == null){
            System.out.println("appel offre est null");
            return null;
        }else if(appelOffre.getProduit() == null || appelOffre.getQuantity() <=0){
            System.out.println("Commpliter les info");
            return null;
        }else {
            appelOffre.setReference(GenerateReference.applyGenerateReference());
            appelOffreRepository.save(appelOffre);
            return appelOffre;
        }

    }

    @Override
    public boolean deleteAppelOffre(Long id) {
         appelOffreRepository.deleteById(id);
        return true;
    }

    @Override
    public AppelOffre updateAppelOffre(AppelOffre appelOffre) {
        if (appelOffre == null){
            System.out.println("appel offre est null");
            return null;
        }else {
            appelOffre.setStatusAppelOffre(StatusAppelOffre.VALIDE);
            Produit produit = produitService.getProduitById(appelOffre.getProduit().getId());
            produit.setQuantity(produit.getQuantity() + appelOffre.getQuantity());
            produitService.addProduit(produit);
            appelOffreRepository.save(appelOffre);
            return appelOffre;
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
