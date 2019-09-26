package com.verizon.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.dao.PasswordRepository;
import com.verizon.model.DAOUser;
@Service
public class PasswordService {
@Autowired
private PasswordRepository passwordRepository;

@Autowired
private UserRegistrationService userRegistrationService;
public String loadUserByEmail(String email) {
	DAOUser user=passwordRepository.findByEmail(email);
	user.setPasswordtoken(UUID.randomUUID().toString());

	// Save token to database
	passwordRepository.save(user);
	userRegistrationService.sendPasswordToken(user.getPasswordtoken());
	return "success";
}
}
