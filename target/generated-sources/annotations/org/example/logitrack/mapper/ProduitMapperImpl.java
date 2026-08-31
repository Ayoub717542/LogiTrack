package org.example.logitrack.mapper;

import javax.annotation.processing.Generated;
import org.example.logitrack.DTO.ProduitRequestDTO;
import org.example.logitrack.DTO.ProduitResponceDTO;
import org.example.logitrack.model.Produit;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-31T12:22:05+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class ProduitMapperImpl implements ProduitMapper {

    @Override
    public Produit toEntity(ProduitRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Produit produit = new Produit();

        produit.setNom( dto.getNom() );
        produit.setCategorie( dto.getCategorie() );
        produit.setPrix( dto.getPrix() );
        produit.setQuantiteStock( dto.getQuantiteStock() );

        return produit;
    }

    @Override
    public ProduitResponceDTO toDto(Produit produit) {
        if ( produit == null ) {
            return null;
        }

        ProduitResponceDTO produitResponceDTO = new ProduitResponceDTO();

        produitResponceDTO.setId( produit.getId() );
        produitResponceDTO.setNom( produit.getNom() );
        produitResponceDTO.setCategorie( produit.getCategorie() );
        produitResponceDTO.setPrix( produit.getPrix() );
        produitResponceDTO.setQuantiteStock( produit.getQuantiteStock() );

        return produitResponceDTO;
    }
}
