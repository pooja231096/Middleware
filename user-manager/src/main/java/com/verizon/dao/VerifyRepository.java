package com.verizon.dao;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verizon.model.RegistrationVerifyPOJO;

public interface VerifyRepository extends JpaRepository<RegistrationVerifyPOJO, UUID>{
//	public RegistrationVerifyPOJO findById(UUID id); 
}
