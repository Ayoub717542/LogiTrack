package org.example.logitrack.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dateCommande;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference("client-commandes")
    private Client client;

    @OneToMany(mappedBy = "commande")
    @JsonManagedReference("commande-lignes")
    private List<LigneCommande> lignes;



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDateCommande() { return dateCommande; }
    public void setDateCommande(LocalDate dateCommande) { this.dateCommande = dateCommande; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<LigneCommande> getLignes() { return lignes; }
    public void setLignes(List<LigneCommande> lignes) { this.lignes = lignes; }
}