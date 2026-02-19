package com.spring.data.jpa.demo.security.register;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.data.jpa.demo.model.entity.User;
import com.spring.data.jpa.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class RegisterTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	void testUserRegister() {
		User user = new User();
		user.setUserName("Admin");
		user.setPassword("admin");
		this.userRepository.save(user);
	}
}
