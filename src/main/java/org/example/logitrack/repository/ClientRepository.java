package org.example.logitrack.repository;

import org.example.logitrack.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
Optional<Client> findByClientId(String email);
Page<Client> findAll(Pageable pageable);
}