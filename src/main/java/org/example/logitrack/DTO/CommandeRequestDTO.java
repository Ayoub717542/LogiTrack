package org.example.logitrack.DTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.example.logitrack.Enums.Statuts;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeRequestDTO {
    private LocalDate dateCommande;
    @Enumerated(EnumType.STRING)
    private Statuts statut;
    private int clientId;

}
