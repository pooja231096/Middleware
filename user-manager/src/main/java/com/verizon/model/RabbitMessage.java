package com.verizon.model;

import java.util.UUID;

public class RabbitMessage {
	private String token;
	private String username;
	private String email;
	private UUID userId;
	
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public RabbitMessage(String token, String username, String email, UUID newUserId) {
		super();
		this.token = token;
		this.username = username;
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
}
