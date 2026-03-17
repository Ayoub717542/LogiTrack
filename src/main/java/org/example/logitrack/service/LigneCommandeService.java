package org.example.logitrack.service;

import org.example.logitrack.model.LigneCommande;
import org.example.logitrack.repository.LigneCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    public LigneCommande saveLigne(LigneCommande ligne) {
        return ligneCommandeRepository.save(ligne);
    }

    public List<LigneCommande> getAllLignes() {
        return ligneCommandeRepository.findAll();
    }
}