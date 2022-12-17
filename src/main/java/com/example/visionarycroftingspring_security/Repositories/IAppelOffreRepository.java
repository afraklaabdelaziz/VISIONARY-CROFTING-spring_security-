package com.example.visionarycroftingspring_security.Repositories;

import com.example.visionarycroftingspring_security.Entities.AppelOffre;
import com.example.visionarycroftingspring_security.Entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppelOffreRepository extends JpaRepository<AppelOffre,Long> {
    List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre);
    List<AppelOffre> findAppelOffreByStock(Stock stock);
}
