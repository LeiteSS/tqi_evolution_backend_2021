package br.com.tqi.loanapi.security;

import java.util.Date;

import br.com.tqi.loanapi.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${security.config.EXPIRATION}")
    private String expiration;

    @Value("${security.config.key}")
    private String secret;

    public String getToken(Authentication authentication) {
        User logged = (User) authentication.getPrincipal();
        Date today = new Date();
        Date expDate = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder().setIssuer("API Loan").setSubject(logged.getId().toString())
                .setIssuedAt(today).setExpiration(expDate).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean isTokeValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

}
