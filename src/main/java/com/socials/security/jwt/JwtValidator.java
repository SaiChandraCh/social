package com.socials.security.jwt;

import com.socials.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtValidator {

    public User validate(String token) {
        Key key = JwtGenerator.key;
        System.out.println("JwtValidator Key : "+key.getEncoded());
        User user = null;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("validation token in JwtValidator : "+token);
        System.out.println("----------------------------------------------------------------------");
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();

            user = new User();
            user.setUserName(body.getSubject());
            user.setPassword((String) body.get("password"));
        }
        catch (Exception e) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Exception : "+e);
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------------");
        }

        return user;
    }
}