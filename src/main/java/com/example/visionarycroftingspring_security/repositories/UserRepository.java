package com.example.visionarycroftingspring_security.repositories;

import com.example.visionarycroftingspring_security.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserApp,Long> {
    public UserApp findByEmail(String email);
    public UserApp findByTelephone(String telephone);
}
