package com.mnemonic.service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class JWTService {
	
	private RSAPrivateKey privateKey;
	private RSAPublicKey publicKey;
	private long expirationTime = 180000; // 30 min
	
	// runs once every time the server starts
	@PostConstruct
	private void initKeys() throws NoSuchAlgorithmException {
		
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(2048);
		KeyPair keypair = generator.generateKeyPair();
		this.privateKey = (RSAPrivateKey) keypair.getPrivate();
		this.publicKey = (RSAPublicKey) keypair.getPublic();
		
		
		
		
	}
	
	public String generateToken(String name, String role) {
		return JWT.create()
				.withClaim("user",name)
				.withClaim("role", role)
				.withExpiresAt(new Date(System.currentTimeMillis() + this.expirationTime))
				.sign(Algorithm.RSA256(this.publicKey, this.privateKey));
		
		
	}
	
	
	public String validateToken(String token) throws JWTVerificationException {
		String payloadBase64Encoded = JWT.require(Algorithm.RSA256(this.publicKey, this.privateKey))
		.build()
		.verify(token)
		.getPayload();
		
		
		return new String(Base64.getDecoder().decode(payloadBase64Encoded));
		
		
		
	}
	
	

}
