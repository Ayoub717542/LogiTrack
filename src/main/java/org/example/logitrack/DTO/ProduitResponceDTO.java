package org.example.logitrack.DTO;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResponceDTO {
    private int id;

    private String nom;
    private String categorie;
    private double prix;
    private int quantiteStock;
}
