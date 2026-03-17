package org.example.logitrack.controller;

import org.example.logitrack.model.Produit;
import org.example.logitrack.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }


    @PostMapping
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable Integer id) {
        return produitService.getProduitById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Integer id) {
        produitService.deleteProduit(id);
    }
}