package com.priya.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.priya.model.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	String secretKey;
	public JwtService()
	{
		KeyGenerator keyGenerator;
		try 
		{
			keyGenerator = KeyGenerator.getInstance("HmacSHA256");
			SecretKey key =  keyGenerator.generateKey();
			secretKey = Base64.getEncoder().encodeToString(key.getEncoded());	
		} 
		catch (NoSuchAlgorithmException e) {
		}
	}

	public String generateTokens(Users user) {
		Map<String,Object> claims = new HashMap<>();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+60*60*60))
				.and()
				.signWith(getKey())
				.compact();
	}

	private Key getKey() {
		byte[] key = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(key);
	}
	

}
