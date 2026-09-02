package org.example.logitrack.mapper;

import javax.annotation.processing.Generated;
import org.example.logitrack.DTO.ClientResponceDTO;
import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.example.logitrack.model.Client;
import org.example.logitrack.model.Commande;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-02T13:26:59+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class CommandeMapperImpl implements CommandeMapper {

    @Override
    public Commande toEntity(CommandeRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Commande commande = new Commande();

        commande.setDateCommande( dto.getDateCommande() );
        commande.setStatut( dto.getStatut() );

        return commande;
    }

    @Override
    public CommandeResponceDTO toDto(Commande commande) {
        if ( commande == null ) {
            return null;
        }

        CommandeResponceDTO commandeResponceDTO = new CommandeResponceDTO();

        commandeResponceDTO.setId( commande.getId() );
        commandeResponceDTO.setDateCommande( commande.getDateCommande() );
        if ( commande.getStatut() != null ) {
            commandeResponceDTO.setStatut( commande.getStatut().name() );
        }
        commandeResponceDTO.setClient( clientToClientResponceDTO( commande.getClient() ) );

        return commandeResponceDTO;
    }

    protected ClientResponceDTO clientToClientResponceDTO(Client client) {
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
