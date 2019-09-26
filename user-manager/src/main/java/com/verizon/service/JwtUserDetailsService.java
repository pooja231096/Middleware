package com.verizon.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.verizon.config.JwtTokenUtil;
import com.verizon.dao.ProfileDao;
import com.verizon.dao.RegisterDao;
import com.verizon.dao.UserDao;
import com.verizon.dao.VerifyDao;
import com.verizon.model.DAOUser;
import com.verizon.model.DAOVerify;
import com.verizon.model.LoginPOJO;
import com.verizon.model.RegDTO;
import com.verizon.model.RegisterPOJO;
import com.verizon.model.UserDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private RegisterDao regDao;
	@Autowired
	private VerifyDao verifyDao;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	private UserRegistrationService userRegistrationService;
	@Value("${jwt.secret}")
	private String secret;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginPOJO user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		user.setLast_login(new Date());
		userDao.save(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public RegisterPOJO save(@Valid RegDTO user) {
		RegisterPOJO newUser = new RegisterPOJO();
		DAOVerify newverify=new DAOVerify();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setCreated_on(new Date());
		regDao.save(newUser);
		newverify.setId(newUser.getId());
		String token=jwtTokenUtil.generateToken1(newUser);
		Date expiry=jwtTokenUtil.tokenExpired(token);
		newverify.setToken(token);
		newverify.setExpiry(expiry);
		verifyDao.save(newverify);
		userRegistrationService.publishMessage(newUser.getUsername());
		System.out.println("UserReg Worked fine!");
		System.out.println(newUser.getUsername());
		return newUser;	
	}


	public String createProfile(String token,UserDTO user ) {
		// TODO Auto-generated method stub
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		DAOUser profile=profileDao.findByUsername(claims.getSubject());
		profile.setDob(user.getDob());
		profile.setGender(user.getGender());
		profile.setAddress(user.getAddress());
		profile.setPhoneno(user.getPhoneno());
		profileDao.save(profile);
		return "Profile created";
	}
	
	
}