package com.verizon.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserRegistrationPOJO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private UUID id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name= "email")
	private String email;
	@Column
	private String passwordtoken;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordtoken() {
		return passwordtoken;
	}
	public void setPasswordtoken(String passwordtoken) {
		this.passwordtoken = passwordtoken;
	}
	
}
