package org.example.logitrack.auth;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.AuthenticationRequestDTO;
import org.example.logitrack.DTO.AuthenticationResponceDTO;
import org.example.logitrack.DTO.RegisterRequoestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final  AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponceDTO> register(@RequestBody RegisterRequoestDTO register){
        return ResponseEntity.ok(authenticationService.register(register));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponceDTO> login(@RequestBody  AuthenticationRequestDTO authenticationRequestDTO){
        return ResponseEntity.ok(authenticationService.login(authenticationRequestDTO));
    }
}
