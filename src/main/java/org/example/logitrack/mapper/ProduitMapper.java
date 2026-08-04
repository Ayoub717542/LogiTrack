package org.example.logitrack.mapper;

import org.example.logitrack.DTO.ProduitRequestDTO;
import org.example.logitrack.DTO.ProduitResponceDTO;
import org.example.logitrack.model.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitMapper
{
    Produit toEntity(ProduitRequestDTO dto);
    ProduitResponceDTO ToDto(Produit produit);

}
