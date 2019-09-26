package com.verizon.service;
import java.util.UUID;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.verizon.dao.UserRepository;
import com.verizon.dao.VerifyRepository;
import com.verizon.model.RabbitMessage;
import com.verizon.model.RegistrationVerifyPOJO;
import com.verizon.model.UserRegistrationPOJO;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VerifyRepository verifyRepository;
	
	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private DirectExchange directExchange;
	@Autowired
	private DirectExchange directExchange1;
	
	public void publishMessage(String usrname) {
		System.out.println("You are halfway there!");
		UserRegistrationPOJO newusr = userRepository.findByUsername(usrname);
		UUID newUserId = newusr.getId();
		String newUserEmail = newusr.getEmail();
		RegistrationVerifyPOJO verifyObj = verifyRepository.findById(newUserId).get(); 
		String newUserToken = verifyObj.getToken();
		RabbitMessage msg = new RabbitMessage(newUserToken, usrname, newUserEmail,newUserId);
		template.convertAndSend(directExchange.getName(), "RegistrationRoutingKey", msg);
		System.out.println(directExchange.getName());
		System.out.println("Ha ha ha ha!");
		System.out.println(msg);
		System.out.println(newUserId+" "+newUserEmail);
      getEmployees();
	}

    private static void getEmployees() 
    {
        System.out.println("I got in here");
        
        
        final String uri = "http://localhost:8081/sendMail";
         
        try {
        	
        RestTemplate restTemplate = new RestTemplate();
        
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        }catch (Exception e) {
        	e.printStackTrace();
			// TODO: handle exception
		}
        
        
        
        
        }
    public void sendPasswordToken(String ptoken) {
		UserRegistrationPOJO newusr = userRepository.findByPasswordtoken(ptoken);
		UUID newUserId = newusr.getId();
		String newUsername=newusr.getUsername();
		String newUserEmail = newusr.getEmail();
		String newPasswordToken = newusr.getPasswordtoken();
		RabbitMessage msg = new RabbitMessage(newPasswordToken, newUsername, newUserEmail,newUserId);
		System.out.println(directExchange1);
		template.convertAndSend(directExchange1.getName(), "PasswordRoutingKey", msg);
		getResetPassword();
	}
    private static void getResetPassword() 
    {
        System.out.println("I got in here to reset password");
        
        
        final String uri = "http://localhost:8081/reset";
         
        try {
        	
        RestTemplate restTemplate = new RestTemplate();
        
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        }catch (Exception e) {
        	e.printStackTrace();
			// TODO: handle exception
		}
    
   
}
}
