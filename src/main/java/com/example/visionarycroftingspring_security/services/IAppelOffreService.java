package com.example.visionarycroftingspring_security.services;


import com.example.visionarycroftingspring_security.entities.AppelOffre;
import com.example.visionarycroftingspring_security.entities.StatusAppelOffre;
import com.example.visionarycroftingspring_security.entities.Stock;
import com.example.visionarycroftingspring_security.services.Dto.ResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IAppelOffreService {
    public List<AppelOffre> getAppelOffres();

    public ResponseDTO addAppelOffre(AppelOffre appelOffre);

    public boolean deleteAppelOffre(Long id);

    public ResponseDTO updateAppelOffre(AppelOffre appelOffre, Long idFournisseur);

    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre);

    public List<AppelOffre> findAppelOffrsByStock(Stock stock);

    Optional<AppelOffre> findById(Long id);
}
