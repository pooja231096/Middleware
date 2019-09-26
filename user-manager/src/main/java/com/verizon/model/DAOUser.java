package com.verizon.model;

import java.sql.Date;
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
public class DAOUser {

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
	private String passwordtoken;
	@Column
	private Boolean active_status;
	@Column
	private Boolean email_verify_status;
	@Column
	private String gender;
	@Column
	private Date dob;
	@Column
	private String address;
	@Column
	private Integer phoneno;
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

	public Boolean getActive_status() {
		return active_status;
	}

	public void setActive_status(Boolean active_status) {
		this.active_status = active_status;
	}

	public Boolean getEmail_verify_status() {
		return email_verify_status;
	}

	public void setEmail_verify_status(Boolean email_verify_status) {
		this.email_verify_status = email_verify_status;
	}

	public String getPasswordtoken() {
		return passwordtoken;
	}

	public void setPasswordtoken(String passwordtoken) {
		this.passwordtoken = passwordtoken;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Integer phoneno) {
		this.phoneno = phoneno;
	}
	

}