package org.example.logitrack.mapper;

import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.example.logitrack.model.Commande;
import org.example.logitrack.model.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande toEntity(CommandeRequestDTO dto);
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "lignes", target = "ligneIds")
    CommandeResponceDTO toDto(Commande commande);

    default List<Integer> mapLigneIds(List<LigneCommande> lignes) {
        if (lignes == null) {
            return null;
        }

        return lignes.stream()
                .map(LigneCommande::getId)
                .toList();
    }
}
