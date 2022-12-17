package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Long> {
    Stock findByEmail(String email);

    Stock findByTelephone(String telephone);
}
