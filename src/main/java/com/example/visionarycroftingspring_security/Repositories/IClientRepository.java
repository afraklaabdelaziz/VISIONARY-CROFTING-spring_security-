package com.example.visionarycroftingspring_security.Repositories;

import com.example.visionarycroftingspring_security.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {
    public Client findByEmail(String email);

    Client findByTelephone(String telephone);
}
