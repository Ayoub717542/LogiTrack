package org.example.logitrack.mapper;

import javax.annotation.processing.Generated;
import org.example.logitrack.DTO.LigneCommandeRequestDTO;
import org.example.logitrack.DTO.LigneCommandeResponceDTO;
import org.example.logitrack.model.Commande;
import org.example.logitrack.model.LigneCommande;
import org.example.logitrack.model.Produit;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-27T17:11:56+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class LigneCommandeMapperImpl implements LigneCommandeMapper {

    @Override
    public LigneCommande toEntity(LigneCommandeRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LigneCommande ligneCommande = new LigneCommande();

        ligneCommande.setQuantite( dto.getQuantite() );

        return ligneCommande;
    }

    @Override
    public LigneCommandeResponceDTO toDto(LigneCommande ligneCommande) {
        if ( ligneCommande == null ) {
            return null;
        }

        LigneCommandeResponceDTO ligneCommandeResponceDTO = new LigneCommandeResponceDTO();

        ligneCommandeResponceDTO.setCommandeId( ligneCommandeCommandeId( ligneCommande ) );
        ligneCommandeResponceDTO.setProduitId( ligneCommandeProduitId( ligneCommande ) );
        ligneCommandeResponceDTO.setId( ligneCommande.getId() );
        ligneCommandeResponceDTO.setQuantite( ligneCommande.getQuantite() );

        return ligneCommandeResponceDTO;
    }

    private int ligneCommandeCommandeId(LigneCommande ligneCommande) {
        if ( ligneCommande == null ) {
            return 0;
        }
        Commande commande = ligneCommande.getCommande();
        if ( commande == null ) {
            return 0;
        }
        int id = commande.getId();
        return id;
    }

    private int ligneCommandeProduitId(LigneCommande ligneCommande) {
        if ( ligneCommande == null ) {
            return 0;
        }
        Produit produit = ligneCommande.getProduit();
        if ( produit == null ) {
            return 0;
        }
        int id = produit.getId();
        return id;
    }
}
