package com.example.visionarycroftingspring_security.Services;


import com.example.visionarycroftingspring_security.Entities.AppelOffre;
import com.example.visionarycroftingspring_security.Entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.Entities.Stock;

import java.util.List;
import java.util.Optional;

public interface IAppelOffreService {
    public List<AppelOffre> getAppelOffres();

    public AppelOffre addAppelOffre(AppelOffre appelOffre);

    public boolean deleteAppelOffre(Long id);

    public AppelOffre updateAppelOffre(AppelOffre appelOffre);

    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre);

    public List<AppelOffre> findAppelOffrsByStock(Stock stock);

    Optional<AppelOffre> findById(Long id);
}
