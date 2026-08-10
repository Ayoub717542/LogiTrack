package org.example.logitrack.controller;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.ClientRequestDTO;
import org.example.logitrack.DTO.ClientResponceDTO;
import org.example.logitrack.service.serviceImpl.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping("/addClient")
    public ResponseEntity<ClientResponceDTO> addClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.ok(clientService.saveClient(clientRequestDTO));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'AGENT')")
    @GetMapping("/getAllClientPagination")
    public ResponseEntity<Page<ClientResponceDTO>> getAllClients(
            @RequestParam (defaultValue = "1") int PageNumber,
            @RequestParam (defaultValue = "5") int PageSize,
            @RequestParam (defaultValue = "nom") String SortBy,
            @RequestParam (defaultValue = "asc") String SortDir
    ) {
        Sort sort = SortDir.equalsIgnoreCase("asc") ? Sort.by(SortBy).ascending() : Sort.by(SortBy).descending();
        Pageable pageable = PageRequest.of(PageNumber-1,PageSize,sort);
        Page<ClientResponceDTO> rs =clientService.getAllClients(pageable);
        return ResponseEntity.ok(rs);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getClientById/{id}")
    public ResponseEntity<ClientResponceDTO> getClient(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.getClientById(id)
        );
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<Boolean> deleteClient(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.deleteClient(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/countClients")
    public ResponseEntity<Long> countClients(){
        return  ResponseEntity.ok(clientService.countClient());
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PutMapping("/updateClient/{id}")
    public ResponseEntity<ClientResponceDTO> updateClient(@PathVariable int id , @RequestBody ClientRequestDTO clientRequestDTO){
        return ResponseEntity.ok(clientService.updateClient(id,clientRequestDTO)) ;
    }
}
