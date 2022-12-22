package com.example.visionarycroftingspring_security.services;

import com.example.visionarycroftingspring_security.entities.Category;
import com.example.visionarycroftingspring_security.entities.CommandeItem;
import com.example.visionarycroftingspring_security.entities.Produit;
import com.example.visionarycroftingspring_security.entities.Stock;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;

import java.util.List;

public interface IProduitService {

    ResponseDTO addProduit(Produit produit);
    Produit updateProduit(Produit produit, Long productId);
    Produit getProduitById(Long id);
    List<Produit> getAllProduits();
    boolean deleteProduit(Long id);
    List<Produit> findProuitsByCategory(Category category);
    List<Produit> findProuitsByCategoryAndStock(Stock stock,Category category);
    void updateProduitQuantity(Produit produit);
    List<Produit> findByStock(Stock stock);
    List<Produit> findProduitByPrixInitialBetween(Double priceMin,Double priceMax);

    List<Produit> findProduitByPrixInitialBetweenStock(Stock stock, Double priceMin, Double priceMax);
}

