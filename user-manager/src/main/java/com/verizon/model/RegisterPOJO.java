package com.verizon.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class RegisterPOJO {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	@Column(unique = true)
	private String username;
	@Column
	//@Size(min = 5 ,max = 10)
	@JsonIgnore
	private String password;
	@NotNull
	@Email
@Pattern(regexp = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$",message = "Please enter an invalid gmail")
	@Column(unique = true)
	private String email;
	@Column 
	private Date created_on;
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private DAOVerify daoverify;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public DAOVerify getDaoverify() {
		return daoverify;
	}

	public void setDaoverify(DAOVerify daoverify) {
		this.daoverify = daoverify;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(java.util.Date date) {
		this.created_on = date;
	}

	

}