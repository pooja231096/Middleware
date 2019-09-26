package com.verizon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.model.RegDTO;
import com.verizon.model.UserDTO;
import com.verizon.service.JwtUserDetailsService;
import com.verizon.service.PasswordService;

@RestController
public class UserController {
	@Autowired
	private PasswordService passwordService;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@RequestMapping({ "/user" })
	public String firstPage() {
		return "User has login successfully";
		//displays only when a jwt token is given
	}
	@RequestMapping(value = "/forgot/{email}", method = RequestMethod.GET)
	public String displayForgotPasswordPage(@PathVariable("email") String email) {
		String str=passwordService.loadUserByEmail(email);
		return str;
	}
	
	@RequestMapping(value = "/createProfile/{token}", method = RequestMethod.POST)
	public String profilePage(@Valid @RequestBody UserDTO user,@PathVariable("token") String token) {
		String str=userDetailsService.createProfile(token, user);
		return str;
	}

}