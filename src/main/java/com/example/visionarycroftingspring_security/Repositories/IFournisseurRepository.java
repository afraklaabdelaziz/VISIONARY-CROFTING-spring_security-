package com.example.visionarycroftingspring_security.Repositories;

import com.example.visionarycroftingspring_security.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFournisseurRepository extends JpaRepository<Fournisseur,Long> {
    Fournisseur findByEmail(String email);

   Fournisseur findByTelephone(String telephone);
}
