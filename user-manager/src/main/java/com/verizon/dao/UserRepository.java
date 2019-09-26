package com.verizon.dao;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.model.UserRegistrationPOJO;

public interface UserRepository extends JpaRepository<UserRegistrationPOJO, UUID>{

	public UserRegistrationPOJO findByUsername(String usrname);
	public UserRegistrationPOJO findByPasswordtoken(String ptoken);
}
