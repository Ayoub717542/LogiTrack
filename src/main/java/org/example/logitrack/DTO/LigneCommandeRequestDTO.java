package org.example.logitrack.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LigneCommandeRequestDTO {
        @NonNull
        private int quantite;
        @NonNull
        private int commandeId;
        @NonNull
        private int produitId;
}
