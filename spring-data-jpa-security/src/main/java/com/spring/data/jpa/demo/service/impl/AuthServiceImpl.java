package com.spring.data.jpa.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.jpa.demo.model.dto.UserDto;
import com.spring.data.jpa.demo.model.entity.Role;
import com.spring.data.jpa.demo.model.entity.User;
import com.spring.data.jpa.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthServiceImpl implements com.spring.data.jpa.demo.service.AuthService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	@Override
	public void register(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub

		User existingUser = this.userRepository.findByUserName(userDto.getUsername());
		
		if(existingUser != null) {
			throw new Exception("User already existed.");
		} else {
			User user = new User();
			user.setUserName(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			
			Role role = new Role();
			role.setRole("ROLE_USER");
			user.getRoles().add(role);
			
			this.userRepository.save(user);
			userDto.setPassword(user.getPassword());
		}
	}

}
