package org.example.logitrack.service;

import org.example.logitrack.model.Produit;
import org.example.logitrack.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Integer id) {
        return produitRepository.findById(id).orElse(null);
    }

    public void deleteProduit(Integer id) {
        produitRepository.deleteById(id);
    }
}