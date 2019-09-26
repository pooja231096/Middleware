package com.verizon.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.model.DAOUser;

@Repository
public interface PasswordRepository extends JpaRepository<DAOUser, UUID>{

	public DAOUser findByEmail(String email);
	public String findByPasswordtoken(String passwordtoken);
	

}

