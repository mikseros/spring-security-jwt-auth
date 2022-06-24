package com.mikseros.springjwtauth.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mikseros.springjwtauth.user.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24H
	
	@Value("${app.jwt.secret}")
	private String secretKey;
	
	public String generateAccessToken(User user) {
		return Jwts.builder()
				.setSubject(user.getId() + ", " + user.getEmail())
				.setIssuer("Mikseros")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
}
