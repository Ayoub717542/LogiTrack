package org.example.logitrack.mapper;

import org.example.logitrack.DTO.LigneCommandeRequestDTO;
import org.example.logitrack.DTO.LigneCommandeResponceDTO;
import org.example.logitrack.model.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LigneCommandeMapper {
    LigneCommande toEntity(LigneCommandeRequestDTO dto);
    @Mapping(source = "commande.id", target = "commandeId")
    @Mapping(source = "produit.id", target = "produitId")
    LigneCommandeResponceDTO toDto(LigneCommande ligneCommande);
}
