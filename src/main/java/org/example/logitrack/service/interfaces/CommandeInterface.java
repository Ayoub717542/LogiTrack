package org.example.logitrack.service.interfaces;

import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommandeInterface {
    CommandeResponceDTO saveCommande(CommandeRequestDTO commandeRequestDTO);
    CommandeResponceDTO getCommandeById(Integer id);
    Page<CommandeResponceDTO> getCommandesByClient(Integer clientId, Pageable pageable);
    Boolean deleteCommande(Integer id);
    CommandeResponceDTO updateStatus(Integer id, String status);
}
