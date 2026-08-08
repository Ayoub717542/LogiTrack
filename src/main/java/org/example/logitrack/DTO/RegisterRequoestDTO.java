package org.example.logitrack.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequoestDTO {
    private String firstname;
    private String lastname;
    private  String userEmail;
    private String password;
}
