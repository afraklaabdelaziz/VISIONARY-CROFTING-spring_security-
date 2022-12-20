package com.example.visionarycroftingspring_security.services.Impl;

import com.example.visionarycrofting.Utiles.GenerateReference;
import com.example.visionarycroftingspring_security.entities.Category;
import com.example.visionarycroftingspring_security.entities.CommandeItem;
import com.example.visionarycroftingspring_security.entities.Produit;
import com.example.visionarycroftingspring_security.entities.Stock;
import com.example.visionarycroftingspring_security.repositories.IproduitRepository;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;
import com.example.visionarycroftingspring_security.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitImpl implements IProduitService {
    @Autowired
    IproduitRepository produitRepository;
    @Override
    public ResponseDTO addProduit(Produit produit) {
        if (produit == null){
            return new ResponseDTO("Bad request","produit est null");
        }else if(produit.getNom() == null || produit.getDescription() == null ||
                produit.getCategory() == null || produit.getPrixInitial() == null ||
         produit.getQuantity() == null || produit.getQuantity()<0){
            return new ResponseDTO("Bad request","compliter les information de produit");
        }else {
            produit.setReference(GenerateReference.applyGenerateReference());
            produitRepository.save(produit);
        }
        return new ResponseDTO("200","avec sucsee",produit);
    }

    @Override
    public Produit updateProduit(Produit produit, Long productId) {
        return null;
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public boolean deleteProduit(Long id) {
        return false;
    }

    @Override
    public List<Produit> findProuitsByCategory(Category category) {
        return produitRepository.findProduitByCategory(category);
    }

    @Override
    public List<Produit> findProuitsByCategoryAndStock(Stock stock, Category category) {
        return produitRepository.findProduitByStockAndCategory(stock,category);
    }

    @Override
    public void updateProduitQuantity(Produit produit1, CommandeItem commandeItems) {

    }

    @Override
    public List<Produit> findByStock(Stock stock) {
        return produitRepository.findProduitByStock(stock);
    }

    @Override
    public List<Produit> findProduitByPrixInitialBetween(Double priceMin, Double priceMax) {
        return produitRepository.findProduitByPrixInitialBetween(priceMin,priceMax);
    }

    @Override
    public List<Produit> findProduitByPrixInitialBetweenStock(Stock stock, Double priceMin, Double priceMax) {
        return produitRepository.findProduitByStockAndPrixInitialBetween(stock,priceMin,priceMax);
    }
}
