package com.slloww.lgpd.repositories;

import com.slloww.lgpd.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findByUsername(String username);
    Optional<Client> findByEmail(String email);
}
