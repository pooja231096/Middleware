package com.verizon.model;

import java.sql.Date;

public class UserDTO {
	private String username;
	private String password;
	private String email;
private Boolean active_status;
private Boolean email_verify_status;
private String gender;
private String address;
private Date dob;
private Date created_on;
private Integer phoneno;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Integer getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Integer phoneno) {
		this.phoneno = phoneno;
	}

	
}