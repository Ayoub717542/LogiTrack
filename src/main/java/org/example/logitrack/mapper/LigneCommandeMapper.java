package org.example.logitrack.mapper;

import org.example.logitrack.DTO.LigneCommandeRequestDTO;
import org.example.logitrack.DTO.LigneCommandeResponceDTO;
import org.example.logitrack.model.LigneCommande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LigneCommandeMapper {
    LigneCommande toEntity(LigneCommandeRequestDTO dto);
    LigneCommandeResponceDTO toDto(LigneCommande ligneCommande);
}
