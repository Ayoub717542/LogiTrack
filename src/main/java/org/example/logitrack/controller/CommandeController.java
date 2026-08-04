package org.example.logitrack.controller;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.example.logitrack.service.serviceImpl.CommandeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService commandeService;


    @PostMapping
    public ResponseEntity<CommandeResponceDTO> createCommande(@RequestBody CommandeRequestDTO commandeRequestDTO) {
        return ResponseEntity.ok(commandeService.saveCommande(commandeRequestDTO));
    }

    @GetMapping("/commandes")
    public ResponseEntity<Page<CommandeResponceDTO>> getAllCommandes(

            @RequestParam (defaultValue = "1") int pageNumber,
            @RequestParam (defaultValue = "5") int pageSize,
            @RequestParam (defaultValue = "dateCommande") String sortBy,
            @RequestParam (defaultValue = "asc") String  sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize,sort);
        Page<CommandeResponceDTO> rs = commandeService.getAllCommandes(pageable);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/commande/{id}")
    public ResponseEntity<CommandeResponceDTO> getCommande(@PathVariable Integer id)
    {
        return ResponseEntity.ok(commandeService.getCommandeById(id));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<Page<CommandeResponceDTO>> getByClient(@PathVariable Integer clientId, Pageable pageable) {
        return ResponseEntity.ok(commandeService.getCommandesByClient(clientId, pageable));
    }

    @PutMapping("/updateStatus/{id}/status")
    public ResponseEntity<CommandeResponceDTO> updateStatus(@PathVariable Integer id, @RequestParam String status) {
        return ResponseEntity.ok(commandeService.updateStatus(id, status));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCommande(@PathVariable Integer id) {
        return ResponseEntity.ok(commandeService.deleteCommande(id));
    }
}