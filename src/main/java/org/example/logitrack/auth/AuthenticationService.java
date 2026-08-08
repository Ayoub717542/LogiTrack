package org.example.logitrack.auth;

import lombok.RequiredArgsConstructor;
import org.example.logitrack.DTO.AuthenticationRequestDTO;
import org.example.logitrack.DTO.AuthenticationResponceDTO;
import org.example.logitrack.DTO.RegisterRequoestDTO;
import org.example.logitrack.Enums.Role;
import org.example.logitrack.config.JwtService;
import org.example.logitrack.model.User;
import org.example.logitrack.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private  final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;

    private  final AuthenticationManager authenticationManager;

    public  AuthenticationResponceDTO register(RegisterRequoestDTO registerRequoestDTO) {
        User user = User.builder()
                .firstName(registerRequoestDTO.getFirstname())
                .lastName(registerRequoestDTO.getLastname())
                .email(registerRequoestDTO.getUserEmail())
                .password(passwordEncoder.encode(registerRequoestDTO.getPassword()))
                .role(Role.AGENT)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponceDTO.builder()
                .token(jwtToken)
                .userEmail(user.getEmail())
                .build();
    }

    public  AuthenticationResponceDTO login(AuthenticationRequestDTO authenticationRequestDTO) {
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       authenticationRequestDTO.getUserEmail(),
                       authenticationRequestDTO.getPassword()
               )
       );
       User user = userRepository.findByEmail(authenticationRequestDTO.getUserEmail()).orElseThrow(() -> new UsernameNotFoundException("user not found!!"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponceDTO.builder()
                .token(jwtToken)
                .userEmail(user.getEmail())
                .build();
    }
}
