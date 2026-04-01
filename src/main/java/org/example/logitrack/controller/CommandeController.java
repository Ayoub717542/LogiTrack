package org.example.logitrack.controller;

import org.example.logitrack.model.Commande;
import org.example.logitrack.service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }
    // POST /api/commandes
    @PostMapping("/client/{clientId}")
    public Commande createCommandeForClient(@PathVariable Integer clientId) {
        Commande commande = new Commande();

        commande.setClient(commandeService.getClientById(clientId));

        commande.setStatut("EN_ATTENTE");
        commande.setDateCommande(java.time.LocalDate.now());

        return commandeService.saveCommande(commande);
    }
    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }
    @GetMapping("/{id}")
    public Commande getCommande(@PathVariable Integer id) {
        return commandeService.getCommandeById(id);
    }
    // GET /api/commandes/client/{clientId}
    @GetMapping("/client/{clientId}")
    public List<Commande> getByClient(@PathVariable Integer clientId) {
        return commandeService.getCommandesByClient(clientId);
    }
    // PUT /api/commandes/{id}/status
    @PutMapping("/{id}/status")
    public Commande updateStatus(@PathVariable Integer id, @RequestParam String status) {
        Commande commande = commandeService.getCommandeById(id);
        if (commande != null) {
            commande.setStatut(status);
            return commandeService.saveCommande(commande);
        }
        return null;
    }
}