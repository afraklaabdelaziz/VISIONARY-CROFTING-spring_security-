package com.example.visionarycroftingspring_security.Repositories;

import com.example.visionarycroftingspring_security.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Long> {
    Stock findByEmail(String email);

    Stock findByTelephone(String telephone);
}
