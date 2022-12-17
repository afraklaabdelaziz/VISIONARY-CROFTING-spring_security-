package com.example.visionarycrofting.Services;

import com.example.visionarycrofting.Entities.AppelOffre;
import com.example.visionarycrofting.Entities.StatusAppelOffre;
import com.example.visionarycrofting.Entities.Stock;

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
