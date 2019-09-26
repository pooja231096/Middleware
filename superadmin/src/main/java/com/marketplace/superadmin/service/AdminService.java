package com.marketplace.superadmin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.superadmin.model.User;
import com.marketplace.superadmin.repository.AdminRepo;


@Service
public class AdminService {
	@Autowired
	private AdminRepo adminRepo;
	
	public List<User> getAllUsers() {
		return adminRepo.findAll();
	}
	
	public User findUserById(UUID id)
	{
		return adminRepo.findUserById(id);
	}
	
	public User AddUser(User user)
	{
		return adminRepo.save(user);
	}
	
	
}
