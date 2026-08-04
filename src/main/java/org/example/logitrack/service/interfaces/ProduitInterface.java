package org.example.logitrack.service.interfaces;

import org.example.logitrack.DTO.ProduitRequestDTO;
import org.example.logitrack.DTO.ProduitResponceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProduitInterface {
    ProduitResponceDTO saveProduit(ProduitRequestDTO produitRequestDTO);
    Page<ProduitResponceDTO> getAllProduits(Pageable pageable);
    ProduitResponceDTO getProduitById(Integer id);
    Boolean deleteProduit(Integer id);
}
