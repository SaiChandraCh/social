package com.socials.security.jwt;

import com.socials.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtGenerator {
    static Key key;
    public String generate(User user) {
        Claims claims = Jwts.claims()
                .setSubject(user.getUserName());
        claims.put("password", (user.getPassword()));

        key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String token = Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + 1000*60))
                    .signWith(key).compact();
        System.out.println("token : "+token);
        return token;
    }
}