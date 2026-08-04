package org.example.logitrack.DTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeRequestDTO {
    private LocalDate dateCommande;
    private String statut;
    private int clientId;

}
