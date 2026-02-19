package com.spring.data.jpa.demo.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {

	String username;
	String password;
}
