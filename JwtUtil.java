package com.example.demo.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	 private final String secret = "yourSecretKey";
	    private final long expirationMs = 3600000;

	    public String generateToken(String username) {
	        return Jwts.builder()
	                   .setSubject(username)
	                   .setIssuedAt(new Date())
	                   .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
	                   .signWith(SignatureAlgorithm.HS512, secret)
	                   .compact();
	    }

	    public String extractUsername(String token) {
	        return Jwts.parser()
	                   .setSigningKey(secret)
	                   .parseClaimsJws(token)
	                   .getBody()
	                   .getSubject();
	    }

}
