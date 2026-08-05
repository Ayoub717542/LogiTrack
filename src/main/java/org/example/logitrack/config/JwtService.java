package org.example.logitrack.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class JwtService {
    private static  final String SECRET_KEY="DE7D1440A4930996A6822E1FBEC6C3900B7CE1FA251A15AAB5D73C912312D7E8";
    public String extractUsername(String token) {
        return null;
    }
    private Claims extractAllClaims (String token){
        return Jwts.parser()
                .verifyWith(getSignInKey()) // verify the sender of the jwt is who it claims to be and the message does not change at all.
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private PublicKey getSignInKey() {
        return null;
    }
}
