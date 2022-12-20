package com.example.visionarycroftingspring_security.repositories;

import com.example.visionarycroftingspring_security.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Long> {
    Stock findByEmail(String email);

    Stock findByTelephone(String telephone);
}
