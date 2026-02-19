package com.spring.data.jpa.demo.service;

import com.spring.data.jpa.demo.model.dto.UserDto;

public interface AuthService {
	public void register(UserDto userDto) throws Exception;
}
