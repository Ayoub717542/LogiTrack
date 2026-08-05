package org.example.logitrack.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.logitrack.DTO.LigneCommandeRequestDTO;
import org.example.logitrack.DTO.LigneCommandeResponceDTO;

import org.example.logitrack.service.serviceImpl.CommandeService;
import org.example.logitrack.service.serviceImpl.LigneCommandeService;
import org.example.logitrack.service.serviceImpl.ProduitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@Setter
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ligneCommande")
public class LigneCommandeController {

    private final LigneCommandeService ligneCommandeService;
    private final CommandeService commandeService;
    private final ProduitService produitService;

    @PostMapping("/addProductToOrder/{orderId}/products")
    public ResponseEntity<LigneCommandeResponceDTO> addProductToOrder(@PathVariable Integer orderId, @RequestBody LigneCommandeRequestDTO dto) {
        return ResponseEntity.ok( ligneCommandeService.saveLigne(orderId, dto) );
    }
    @GetMapping("/lignes")
    public ResponseEntity<Page<LigneCommandeResponceDTO>> getAllLignes(Pageable pageable)
    {
        return ResponseEntity.ok( ligneCommandeService.getAllLignes(pageable) );
    }
    @GetMapping("/lignes/{id}")
    public ResponseEntity<LigneCommandeResponceDTO> getLigneById( @PathVariable Integer id)
    {
        return ResponseEntity.ok( ligneCommandeService.getLigneById(id) );
    }
    @DeleteMapping("deleteLigne/lignes/{id}")
    public ResponseEntity<Boolean> deleteLigne( @PathVariable Integer id)
    {
        return ResponseEntity.ok( ligneCommandeService.deleteLigne(id) );
    }
}
