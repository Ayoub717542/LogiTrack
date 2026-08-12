package org.example.logitrack.repository;

import org.example.logitrack.Enums.Statuts;
import org.example.logitrack.model.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    Page<Commande> findById(Integer id, Pageable pageable);
    long countByStatut(Statuts statut);
    long count();
    @Query("select c  from Commande c JOIN FETCH c.client ORDER BY c.dateCommande DESC ")
    Page<Commande> findRecentCommandes(Pageable pageable);
}