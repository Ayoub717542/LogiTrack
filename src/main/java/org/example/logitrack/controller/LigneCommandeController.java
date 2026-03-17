package org.example.logitrack.controller;

import org.example.logitrack.model.Commande;
import org.example.logitrack.model.LigneCommande;
import org.example.logitrack.model.Produit;
import org.example.logitrack.service.CommandeService;
import org.example.logitrack.service.LigneCommandeService;
import org.example.logitrack.service.ProduitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commandes")
public class LigneCommandeController {

    private final LigneCommandeService ligneCommandeService;
    private final CommandeService commandeService;
    private final ProduitService produitService;
    public LigneCommandeController(LigneCommandeService ligneCommandeService,
                                   CommandeService commandeService,
                                   ProduitService produitService) {
        this.ligneCommandeService = ligneCommandeService;
        this.commandeService = commandeService;
        this.produitService = produitService;
    }
    @PostMapping("/{orderId}/products")
    public LigneCommande addProductToOrder(@PathVariable Integer orderId,
                                           @RequestParam Integer productId,
                                           @RequestParam int quantite) {

        Commande commande = commandeService.getCommandeById(orderId);
        Produit produit = produitService.getProduitById(productId);

        LigneCommande ligne = new LigneCommande();
        ligne.setCommande(commande);
        ligne.setProduit(produit);
        ligne.setQuantite(quantite);

        return ligneCommandeService.saveLigne(ligne);
    }
}