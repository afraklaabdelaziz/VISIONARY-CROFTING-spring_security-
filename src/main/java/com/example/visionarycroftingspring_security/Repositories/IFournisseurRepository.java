package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFournisseurRepository extends JpaRepository<Fournisseur,Long> {
    Fournisseur findByEmail(String email);

   Fournisseur findByTelephone(String telephone);
}
