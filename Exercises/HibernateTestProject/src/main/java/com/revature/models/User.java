package com.revature.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
	@SequenceGenerator(name = "userSequence", sequenceName = "SQ_USER_PK")
	@Column(name = "USER_ID")
	private int id;
	
	@Column(name = "USERNAME", unique = true)
	private String username;
	
	@Column(name = "PASS_HASH")
	private String passHash;
	
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@Column(name = "PHONE", unique = true)
	private String phone;
	
	public User() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassHash() {
		return passHash;
	}
	
	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}