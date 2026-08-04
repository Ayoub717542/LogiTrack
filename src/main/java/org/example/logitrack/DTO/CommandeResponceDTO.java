package org.example.logitrack.DTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeResponceDTO {
    private int id;
    private LocalDate dateCommande;
    private String statut;
    private int clientId;
    private List<Integer> ligneIds;
}
