package com.codegym.jwtToken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JwtProvider {

    private final String secretKey = "C0421G1";
    // Generate Tokens Method
    public String generateToken(UserDetails userDetail){
        String[] authorizationAccount = getAuthorizationAccount(userDetail);
        return JWT.create()
                .withIssuer("CODE_GYM")
                .withAudience("ADMIN_USER")
                .withIssuedAt(new Date())
                .withSubject(userDetail.getUsername())
                .withArrayClaim("authorization", authorizationAccount)
                .withExpiresAt(new Date(System.currentTimeMillis() + 30*60*1000))
                .sign(Algorithm.HMAC512(secretKey));
    }

    private String[] getAuthorizationAccount(UserDetails userDetail) {
        List<String> authorization = new ArrayList<>();
        for (GrantedAuthority items: userDetail.getAuthorities()){
            authorization.add(items.getAuthority());
        }
        return authorization.toArray(new String[0]);
    }

    // Decode token
    private JWTVerifier getVerifier(){
        JWTVerifier verifier;
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            verifier = JWT.require(algorithm).withIssuer("CODE_GYM").build();
        }catch (JWTVerificationException exception){
            throw new JWTVerificationException("Can not verifier");
        }
        return verifier;
    }


    public String getUsernameFromToken(String token) {
        JWTVerifier verifier = getVerifier();
        return verifier.verify(token).getSubject();
    }
}
