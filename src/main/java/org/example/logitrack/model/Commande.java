package org.example.logitrack.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.logitrack.Enums.Statuts;

import java.time.LocalDate;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate dateCommande;

    @Enumerated(EnumType.STRING)
    private Statuts statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference("client-commandes")
    private Client client;

    @OneToMany(mappedBy = "commande")
    @JsonManagedReference("commande-lignes")
    private List<LigneCommande> lignes;
}