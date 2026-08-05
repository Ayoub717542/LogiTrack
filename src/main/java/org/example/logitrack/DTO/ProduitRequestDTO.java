package org.example.logitrack.DTO;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequestDTO {
    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;
}
