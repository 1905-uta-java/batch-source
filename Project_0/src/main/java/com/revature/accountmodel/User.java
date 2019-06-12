package com.revature.accountmodel;

import java.io.Serializable;

public class User implements Serializable {
	// Serial ID
	private static final long serialVersionUID = 1L;
	
	// Class attributes
	private int id;
	private String uName;
	private String pWord;
	private String eMail;
	
	// Default Constructor, we shouldn't need to use this
	public User() {
		super();
	}
	// Parameterized constructor
	public User(int id, String uName, String pWord, String eMail) {
		super();
		this.id = id;
		this.uName = uName;
		this.pWord = pWord;
		this.eMail = eMail;
	}
	// Getters and Setters for class attributes
	public int getId() {
		return id;
	}
	
	// Hash Code and Equals methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + id;
		result = prime * result + ((pWord == null) ? 0 : pWord.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
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
		User other = (User) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (id != other.id)
			return false;
		if (pWord == null) {
			if (other.pWord != null)
				return false;
		} else if (!pWord.equals(other.pWord))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		return true;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getpWord() {
		return pWord;
	}
	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	// ToString method
	@Override
	public String toString() {
		return "User [id=" + id + ", uName=" + uName + ", pWord=" + pWord + ", eMail=" + eMail + "]";
	}
	
}
