package com.priya.service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class JwtService {
	
	String secreteKey;
	public JwtService()
	{
		try {
			KeyGenerator generator = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = generator.generateKey();
			secreteKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
	}

}
