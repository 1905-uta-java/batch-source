package com.revature.project1.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtil {
	
	public static PasswordResult hashPassword(String password) {
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		return hashPassword(password, salt);
	}
	
	public static PasswordResult hashPassword(String password, byte[] salt) {
		
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
	
	public static boolean isValidPassword(String password) {
		
		return password != null && password.length() > 5 && password.length() < 13;
	}
}