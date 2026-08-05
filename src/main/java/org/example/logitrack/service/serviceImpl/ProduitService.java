package org.example.logitrack.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.ProduitRequestDTO;
import org.example.logitrack.DTO.ProduitResponceDTO;
import org.example.logitrack.mapper.ProduitMapper;
import org.example.logitrack.model.Produit;
import org.example.logitrack.repository.ProduitRepository;
import org.example.logitrack.service.interfaces.ProduitInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProduitService implements ProduitInterface {

    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;


    public ProduitResponceDTO saveProduit(ProduitRequestDTO produitRequestDTO) {

        Produit produit = produitMapper.toEntity(produitRequestDTO);

        return produitMapper.toDto(
                produitRepository.save(produit)
        );
    }


    public Page<ProduitResponceDTO> getAllProduits(Pageable pageable) {
        return produitRepository.findAll(pageable)
                .map(produit -> produitMapper.toDto(produit));
    }


    public ProduitResponceDTO getProduitById(Integer id) {

        Produit produit = produitRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No produit found with id " + id)
                );

        return produitMapper.toDto(produit);
    }


    public Boolean deleteProduit(Integer id) {

        produitRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No produit found with id " + id)
                );

        produitRepository.deleteById(id);

        return true;
    }
}