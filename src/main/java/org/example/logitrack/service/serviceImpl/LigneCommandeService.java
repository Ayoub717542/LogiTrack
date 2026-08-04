package org.example.logitrack.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.LigneCommandeRequestDTO;
import org.example.logitrack.DTO.LigneCommandeResponceDTO;
import org.example.logitrack.mapper.LigneCommandeMapper;
import org.example.logitrack.model.Commande;
import org.example.logitrack.model.LigneCommande;
import org.example.logitrack.model.Produit;
import org.example.logitrack.repository.CommandeRepository;
import org.example.logitrack.repository.LigneCommandeRepository;
import org.example.logitrack.repository.ProduitRepository;
import org.example.logitrack.service.interfaces.LigneCommandeInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LigneCommandeService implements LigneCommandeInterface {

    private final LigneCommandeRepository ligneCommandeRepository;
    private final LigneCommandeMapper ligneCommandeMapper;
    private  final CommandeRepository commandeRepository;
    private  final ProduitRepository produitRepository;

    public LigneCommandeResponceDTO saveLigne(Integer orderId, LigneCommandeRequestDTO ligneCommandeRequestDTO) {
        Commande commande = commandeRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No commande found with id " + orderId));
        Produit produit = produitRepository.findById(ligneCommandeRequestDTO.getProduitId()
        ).orElseThrow(() ->
                new RuntimeException("No produit found with id " + ligneCommandeRequestDTO.getProduitId()));
        LigneCommande ligneCommande = ligneCommandeMapper.toEntity(ligneCommandeRequestDTO);
        ligneCommande.setCommande(commande);
        ligneCommande.setProduit(produit);
        return ligneCommandeMapper.toDto(ligneCommandeRepository.save(ligneCommande));
    }
    public Page<LigneCommandeResponceDTO> getAllLignes(Pageable pageable) {
        return ligneCommandeRepository.findAll(pageable).map(ligneCommande -> ligneCommandeMapper.toDto(ligneCommande));
    }
    public LigneCommandeResponceDTO getLigneById(Integer id) {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id).orElseThrow(() -> new RuntimeException("No ligne commande found with id " + id));
        return ligneCommandeMapper.toDto(ligneCommande);
    }
    public Boolean deleteLigne(Integer id) {
        ligneCommandeRepository.findById(id).orElseThrow(() -> new RuntimeException("No ligne commande found with id " + id));
        ligneCommandeRepository.deleteById(id);
        return true;
    }
}