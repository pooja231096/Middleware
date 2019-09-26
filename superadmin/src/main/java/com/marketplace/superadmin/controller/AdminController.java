package com.marketplace.superadmin.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.marketplace.superadmin.model.User;
import com.marketplace.superadmin.service.AdminService;



@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return adminService.getAllUsers();
	}
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@GetMapping(value ="/{id}")
    public User getUser(@PathVariable("id") UUID id) {
		User user = adminService.findUserById(id);
        return user;
        }
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@PostMapping(value="/add")
	public User AddUser(@RequestBody User user)
	{
		return adminService.AddUser(user);
	}
	
	
	
}
