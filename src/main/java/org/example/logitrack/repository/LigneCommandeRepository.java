package org.example.logitrack.repository;

import org.example.logitrack.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
@Query("SELECT count(l) from LigneCommande l where l.commande.id    = :commandeID")
    List<LigneCommande> lign
}