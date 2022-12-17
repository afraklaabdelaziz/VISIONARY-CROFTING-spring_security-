package com.example.visionarycroftingspring_security.Services;

import com.example.visionarycroftingspring_security.Entities.Category;
import com.example.visionarycroftingspring_security.Entities.CommandeItem;
import com.example.visionarycroftingspring_security.Entities.Produit;
import com.example.visionarycroftingspring_security.Entities.Stock;

import java.util.List;

public interface IProduitService {

    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit, Long productId);
    Produit getProduitById(Long id);
    List<Produit> getAllProduits();
    boolean deleteProduit(Long id);
    List<Produit> findProuitsByCategory(Category category);
    List<Produit> findProuitsByCategoryAndStock(Stock stock,Category category);
    void updateProduitQuantity(Produit produit1, CommandeItem commandeItems);
    List<Produit> findByStock(Stock stock);
    List<Produit> findProduitByPrixInitialBetween(Double priceMin,Double priceMax);

    List<Produit> findProduitByPrixInitialBetweenStock(Stock stock, Double priceMin, Double priceMax);
}

