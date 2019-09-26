package com.verizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.service.UserRegistrationService;

@RestController
@RequestMapping("/registerPublish")
public class RegistrationPublishController {
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@RequestMapping(value = "/{username}", method=RequestMethod.GET)
	public void publishMessage(@PathVariable("username") String usrname) {
		userRegistrationService.publishMessage(usrname);
	}
	@RequestMapping("/{ptoken}")
	public void sendPasswordToken(@PathVariable("ptoken") String ptoken) {
		userRegistrationService.sendPasswordToken(ptoken);
	}
}
