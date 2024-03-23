package com.personal.depository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.depository.dto.AuthRequest;
import com.personal.depository.entity.User;
import com.personal.depository.service.UserService;
import com.personal.depository.util.JwtUtil;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/create")
	public ResponseEntity<User> createAccount(@RequestBody User user) {
		User userSaved = userService.saveUser(user);
		return new ResponseEntity<User>(userSaved, HttpStatus.CREATED);
	}

	@GetMapping("/test")
	public ResponseEntity<String> testingAPI() {
		return new ResponseEntity<String>("Welcome..!!", HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid username or password");
		}
		return new ResponseEntity<String>(jwtUtil.generateToken(authRequest.getUsername()), HttpStatus.OK);

	}

}