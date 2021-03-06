package com.agenda.api.auth.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String SECRET;

	@Value("${jwt.expiration}")
	private Long EXPIRATION;

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
	}

	public boolean isValidToken(String token) {
		Claims claims = getClaims(token);
		if(claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			
			if(username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		
		return false;
	}
	
	public String getUsername(String token) {
		Claims claims = getClaims(token);
		 
		if(claims != null) 
			return claims.getSubject();
		
		return null;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}
}
