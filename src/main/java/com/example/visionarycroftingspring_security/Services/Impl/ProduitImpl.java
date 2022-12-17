package com.example.visionarycroftingspring_security.Services.Impl;

import com.example.visionarycrofting.Utiles.GenerateReference;
import com.example.visionarycroftingspring_security.Entities.Category;
import com.example.visionarycroftingspring_security.Entities.CommandeItem;
import com.example.visionarycroftingspring_security.Entities.Produit;
import com.example.visionarycroftingspring_security.Entities.Stock;
import com.example.visionarycroftingspring_security.Repositories.IproduitRepository;
import com.example.visionarycroftingspring_security.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitImpl implements IProduitService {
    @Autowired
    IproduitRepository produitRepository;
    @Override
    public Produit addProduit(Produit produit) {
        if (produit == null){
            System.out.println("ce produit est null");
            return null;
        }else if(produit.getNom() == null || produit.getDescription() == null ||
                produit.getCategory() == null || produit.getPrixInitial() == null ||
         produit.getQuantity() == null || produit.getQuantity()<0){
            System.out.println("compliter les information");
            return null;
        }else {
            produit.setReference(GenerateReference.applyGenerateReference());
            produitRepository.save(produit);
        }
        return produit;
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
