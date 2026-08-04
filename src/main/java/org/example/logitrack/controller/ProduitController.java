package org.example.logitrack.controller;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.ProduitRequestDTO;
import org.example.logitrack.DTO.ProduitResponceDTO;
import org.example.logitrack.service.serviceImpl.ProduitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProduitController {

    private final ProduitService produitService;


    @PostMapping("/addProduct")
    public ResponseEntity<ProduitResponceDTO> addProduit(@RequestBody ProduitRequestDTO produitRequestDTO) {
        return ResponseEntity.ok(produitService.saveProduit(produitRequestDTO));
    }

    @GetMapping("/products")
    public ResponseEntity<Page<ProduitResponceDTO>> getAllProduits(
            @RequestParam (defaultValue = "1") int pageNumber,
            @RequestParam (defaultValue = "5") int pageSize,
            @RequestParam (defaultValue = "prix") String sortBy,

            @RequestParam (defaultValue = "asc") String  sortDir
    ){
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() :Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize,sort);
        Page<ProduitResponceDTO> rs =produitService.getAllProduits(pageable);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ProduitResponceDTO> getProduit(@PathVariable Integer id) {
        return ResponseEntity.ok(produitService.getProduitById(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteProduit(@PathVariable Integer id) {
        return ResponseEntity.ok(produitService.deleteProduit(id));
    }
}
