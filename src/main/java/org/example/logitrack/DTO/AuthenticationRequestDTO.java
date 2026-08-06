package org.example.logitrack.DTO;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequestDTO {
    @NonNull
    private String email;
    @NonNull
    private String password;
}
