package org.example.logitrack.mapper;

import org.example.logitrack.DTO.ClientRequestDTO;
import org.example.logitrack.DTO.ClientResponceDTO;
import org.example.logitrack.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ClientMapper {
    Client toEntity(ClientRequestDTO dto);
    ClientResponceDTO toDto(Client client);

}

