package com.revature.project1.util;

import java.util.Arrays;

public class PasswordResult {
	
	private byte[] hash;
	private byte[] salt;
	
	public PasswordResult() {
		super();
	}
	
	public PasswordResult(byte[] hash, byte[] salt) {
		super();
		this.hash = hash;
		this.salt = salt;
	}
	
	public byte[] getHash() {
		return hash;
	}
	
	public void setHash(byte[] hash) {
		this.hash = hash;
	}
	
	public byte[] getSalt() {
		return salt;
	}
	
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(hash);
		result = prime * result + Arrays.hashCode(salt);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PasswordResult other = (PasswordResult) obj;
		if (!Arrays.equals(hash, other.hash))
			return false;
		if (!Arrays.equals(salt, other.salt))
			return false;
		return true;
	}
}