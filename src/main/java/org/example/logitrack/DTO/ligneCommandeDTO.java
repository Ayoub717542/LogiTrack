package org.example.logitrack.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ligneCommandeDTO {
        @NonNull
        public int productId;
        @NonNull
        public int quantite;
}
