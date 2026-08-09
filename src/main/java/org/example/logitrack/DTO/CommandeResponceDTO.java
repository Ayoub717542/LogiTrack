package org.example.logitrack.DTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandeResponceDTO {
    private int id;
    private LocalDate dateCommande;
    private String statut;
    private ClientResponceDTO client;
}
