package com.example.visionarycroftingspring_security.repositories;

import com.example.visionarycroftingspring_security.entities.AppelOffre;
import com.example.visionarycroftingspring_security.entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppelOffreRepository extends JpaRepository<AppelOffre,Long> {
    List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre);
    List<AppelOffre> findAppelOffreByStock(Stock stock);
}
