package com.example.elqasrysami.dao.repositories;

import com.example.elqasrysami.dao.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
