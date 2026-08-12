package org.example.logitrack.controller;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.example.logitrack.Enums.Statuts;
import org.example.logitrack.service.serviceImpl.CommandeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
    private final CommandeService commandeService;

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping("/createCommande")
    public ResponseEntity<CommandeResponceDTO> createCommande(@RequestBody CommandeRequestDTO commandeRequestDTO) {
        return ResponseEntity.ok(commandeService.saveCommande(commandeRequestDTO));
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
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
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/commande/{id}")
    public ResponseEntity<CommandeResponceDTO> getCommande(@PathVariable Integer id)
    {
        return ResponseEntity.ok(commandeService.getCommandeById(id));
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/client/{clientId}")
    public ResponseEntity<Page<CommandeResponceDTO>> getByClient(@PathVariable Integer clientId, Pageable pageable) {
        return ResponseEntity.ok(commandeService.getCommandesByClient(clientId, pageable));
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','AGENT')")
    @PutMapping("/updateStatus/{id}/status")
    public ResponseEntity<CommandeResponceDTO> updateStatus(@PathVariable Integer id, @RequestParam Statuts status) {
        return ResponseEntity.ok(commandeService.updateStatus(id, status));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCommande(@PathVariable Integer id) {
        return ResponseEntity.ok(commandeService.deleteCommande(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/countPending")
    public ResponseEntity<Long> countPending(){
        return  ResponseEntity.ok(commandeService.countPending());
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/countShipped")
    public ResponseEntity<Long> countShipped(){
        return  ResponseEntity.ok(commandeService.countShipped());
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/countDelivered")
    public ResponseEntity<Long> countDelivered(){
        return  ResponseEntity.ok(commandeService.countDelivered());
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/countCanceled")
    public ResponseEntity<Long> countCanceled(){
        return  ResponseEntity.ok(commandeService.countCanceled());
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/countCommandes")
    public ResponseEntity<Long> countCommandes(){
        return  ResponseEntity.ok(commandeService.countCommandes());
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/recentCommandes")
    public ResponseEntity<Page<CommandeResponceDTO>> recentCommandes(
            @RequestParam (defaultValue ="1") int pageNumber,
            @RequestParam (defaultValue ="6") int pageSize
    ){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        return ResponseEntity.ok(commandeService.RecentCommandes(pageable));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PutMapping("/updateCommande/{id}")
    public ResponseEntity<CommandeResponceDTO> updateCommande(
            @PathVariable int id,
            @RequestBody CommandeRequestDTO commandeRequestDTO){
        return ResponseEntity.ok(commandeService.updateCommande(id,commandeRequestDTO));
    }


}