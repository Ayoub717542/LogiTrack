package org.example.logitrack.service;

import org.example.logitrack.model.Client;
import org.example.logitrack.model.Commande;
import org.example.logitrack.repository.ClientRepository;
import org.example.logitrack.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    public CommandeService(CommandeRepository commandeRepository, ClientRepository clientRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
    }

    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(Integer id) {
        return commandeRepository.findById(id).orElse(null);
    }

    public List<Commande> getCommandesByClient(Integer clientId) {
        return commandeRepository.findByClientId(clientId);
    }

    public Client getClientById(Integer clientId) {
        return clientRepository.findById(clientId).orElse(null);    }
}