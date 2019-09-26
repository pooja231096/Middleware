package com.verizon.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.model.LoginPOJO;

@Repository
public interface UserDao extends CrudRepository<LoginPOJO, UUID> {
	
	LoginPOJO findByUsername(String username);
	
	
}