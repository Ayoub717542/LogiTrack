package org.example.logitrack.controller;

import org.example.logitrack.model.Client;
import org.example.logitrack.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}