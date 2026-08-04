package org.example.logitrack.mapper;

import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.example.logitrack.model.Commande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande toEntity(CommandeRequestDTO dto);
    CommandeResponceDTO toDto(Commande commande);
}
