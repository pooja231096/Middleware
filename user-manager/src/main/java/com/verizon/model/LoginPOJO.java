package com.verizon.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class LoginPOJO {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	@Column(unique = true)
	private String username;
	@Column
	private Date last_login;
	@Column
	//@Size(min = 5 ,max = 10)
	@JsonIgnore
	private String password;
	/*@NotNull
	@Email
@Pattern(regexp = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$",message = "Please enter an invalid gmail")
	@Column(unique = true)
	private String email;
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private DAOVerify daoverify;
*/
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	

}