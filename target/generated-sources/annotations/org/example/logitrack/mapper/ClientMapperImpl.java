package org.example.logitrack.mapper;

import javax.annotation.processing.Generated;
import org.example.logitrack.DTO.ClientRequestDTO;
import org.example.logitrack.DTO.ClientResponceDTO;
import org.example.logitrack.model.Client;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-09T00:51:24+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setNom( dto.getNom() );
        client.setEmail( dto.getEmail() );
        client.setTelephone( dto.getTelephone() );

        return client;
    }

    @Override
    public ClientResponceDTO toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientResponceDTO clientResponceDTO = new ClientResponceDTO();

        clientResponceDTO.setId( client.getId() );
        clientResponceDTO.setNom( client.getNom() );
        clientResponceDTO.setEmail( client.getEmail() );
        clientResponceDTO.setTelephone( client.getTelephone() );

        return clientResponceDTO;
    }
}
