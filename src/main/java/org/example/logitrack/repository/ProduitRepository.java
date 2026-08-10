package org.example.logitrack.repository;
import org.example.logitrack.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    long count();
    @Query("SELECT p from Produit p where p.quantiteStock <= 5 order by p.quantiteStock asc")
    List<Produit> getLowStockProducts();
}
