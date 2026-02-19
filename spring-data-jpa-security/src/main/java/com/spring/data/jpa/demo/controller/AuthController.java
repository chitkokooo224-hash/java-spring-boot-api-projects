package com.spring.data.jpa.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.jpa.demo.model.dto.UserDto;
import com.spring.data.jpa.demo.model.entity.User;
import com.spring.data.jpa.demo.repository.UserRepository;
import com.spring.data.jpa.demo.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService authService;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/hello")
	String hello() {
		return "Hello";
	}
	
	@PostMapping(value="/register")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void register(@RequestBody UserDto registerDto) throws Exception {
		authService.register(registerDto);
	}
	
	/*@GetMapping(path="osiv-test/{userId}")
	public User getUserById(@PathVariable Long userId) {
		Optional<User> user = this.userRepository.findById(userId);
		
		return user.get();
	}*/
}
