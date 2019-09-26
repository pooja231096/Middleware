package com.verizon.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.verizon.config.JwtTokenUtil;
import com.verizon.model.JwtRequest;
import com.verizon.model.JwtResponse;
import com.verizon.model.RegDTO;
import com.verizon.model.UserDTO;
import com.verizon.service.JwtUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@RestController
@CrossOrigin

public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Value("${jwt.secret}")
	private String secret;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@Valid @RequestBody RegDTO user) throws Exception {

		// return ResponseEntity.ok(userDetailsService.save(user));
		userDetailsService.save(user);
		return "Success";
	}
	
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@RequestMapping(value = "/valid/{token}", method = RequestMethod.POST)
	public String getUser(@PathVariable("token") String token) throws Exception {
		System.out.println(token);
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		Date expiry_date = claims.getExpiration();
		System.out.print(expiry_date);
		try {
			if (!expiry_date.before(new Date())) {
				return "valid";
			} else {

				throw new Exception("deleted");
			}
		} catch (ExpiredJwtException e) {
			return "JWT Token has expired";
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}