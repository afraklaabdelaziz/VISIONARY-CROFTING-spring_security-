package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.AppelOffre;
import com.example.visionarycrofting.Entities.Category;
import com.example.visionarycrofting.Entities.Produit;
import com.example.visionarycrofting.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IproduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findProduitByStockAndCategory(Stock stock, Category category);
    List<Produit> findProduitByStock(Stock stock);
    List<Produit> findProduitByCategory(Category category);
    List<Produit> findProduitByPrixInitialBetween(Double priceMin,Double priceMax);
    List<Produit> findProduitByStockAndPrixInitialBetween(Stock stock,Double priceMin,Double priceMax);
}
