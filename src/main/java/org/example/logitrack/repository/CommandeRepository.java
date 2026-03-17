package org.example.logitrack.repository;

import org.example.logitrack.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    List<Commande> findByClientId(Integer clientId);
}