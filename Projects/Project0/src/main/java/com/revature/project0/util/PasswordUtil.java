package com.revature.project0.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtil {
	
	public static PasswordResult HashPassword(String password) {
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		return HashPassword(password, salt);
	}
	
	public static PasswordResult HashPassword(String password, byte[] salt) {
		
		PasswordResult result = new PasswordResult();
		
		try {
			
			MessageDigest mDigest = MessageDigest.getInstance("SHA-512");
			
			mDigest.update(salt);
			
			result.setSalt(salt);
			result.setHash(mDigest.digest(password.getBytes(StandardCharsets.UTF_8)));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
}