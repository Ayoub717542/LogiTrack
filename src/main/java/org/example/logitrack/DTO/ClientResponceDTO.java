package org.example.logitrack.DTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponceDTO {
    private int id;
    private String nom;
    private String email;
    private String telephone;
    private List<Integer> commandeIds;
}
