package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.AppelOffre;
import com.example.visionarycrofting.Entities.StatusAppelOffre;
import com.example.visionarycrofting.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppelOffreRepository extends JpaRepository<AppelOffre,Long> {
    List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre);
    List<AppelOffre> findAppelOffreByStock(Stock stock);
}
