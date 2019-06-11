package com.bankname.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptionUtil {
	public static String encryptPassword(String password) {
		String hashPassword = null;
		
		//Check if null
		if(password == null) {
			return "";
		}
		
		try {
			
            //Create MD5 Instance
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(password.getBytes());
            
            byte[] bytes = md.digest();
            
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            //Turn into HashString
            hashPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
		
		return hashPassword;
	}
}
