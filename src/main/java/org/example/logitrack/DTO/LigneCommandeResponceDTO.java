package org.example.logitrack.DTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeResponceDTO {
    private int id;
    private int quantite;
    private int commandeId;
    private int produitId;
}
