package org.example.logitrack.service.interfaces;

import org.example.logitrack.DTO.LigneCommandeRequestDTO;
import org.example.logitrack.DTO.LigneCommandeResponceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LigneCommandeInterface {
    LigneCommandeResponceDTO saveLigne(Integer orderId, LigneCommandeRequestDTO ligneCommandeRequestDTO);
    Page<LigneCommandeResponceDTO> getAllLignes(Pageable pageable);
    LigneCommandeResponceDTO getLigneById(Integer id);
    Boolean deleteLigne(Integer id);
}
