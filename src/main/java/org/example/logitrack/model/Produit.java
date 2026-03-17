package org.example.logitrack.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;

    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> lignes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommande> lignes) {
        this.lignes = lignes;
    }
}