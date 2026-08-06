package org.example.logitrack.mapper;

import javax.annotation.processing.Generated;
import org.example.logitrack.DTO.CommandeRequestDTO;
import org.example.logitrack.DTO.CommandeResponceDTO;
import org.example.logitrack.Enums.Statuts;
import org.example.logitrack.model.Client;
import org.example.logitrack.model.Commande;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-06T01:38:03+0100",
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
        if ( dto.getStatut() != null ) {
            commande.setStatut( Enum.valueOf( Statuts.class, dto.getStatut() ) );
        }

        return commande;
    }

    @Override
    public CommandeResponceDTO toDto(Commande commande) {
        if ( commande == null ) {
            return null;
        }

        CommandeResponceDTO commandeResponceDTO = new CommandeResponceDTO();

        commandeResponceDTO.setClientId( commandeClientId( commande ) );
        commandeResponceDTO.setLigneIds( mapLigneIds( commande.getLignes() ) );
        commandeResponceDTO.setId( commande.getId() );
        commandeResponceDTO.setDateCommande( commande.getDateCommande() );
        if ( commande.getStatut() != null ) {
            commandeResponceDTO.setStatut( commande.getStatut().name() );
        }

        return commandeResponceDTO;
    }

    private int commandeClientId(Commande commande) {
        if ( commande == null ) {
            return 0;
        }
        Client client = commande.getClient();
        if ( client == null ) {
            return 0;
        }
        int id = client.getId();
        return id;
    }
}
