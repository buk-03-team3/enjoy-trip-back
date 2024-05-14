package com.ssafy.enjoyTrip.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoyTrip.user.dto.UserDto;
import com.ssafy.enjoyTrip.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("/users/{uuid}")
	public UserDto userDetail(@PathVariable("uuid") int uuid) {
		UserDto dto = userService.userDetail(uuid);
		return dto;
	}
	
//	@GetMapping("/users/find/{email}")
//	public String findPassword(@PathVariable("email") String email) {
//		// TODO: implement find password
//		return "password";
//	}
	
	@PostMapping("/users")
	public int userRegister(UserDto dto) {
		int result = userService.userRegister(dto);
		if(result==-1) {
			System.out.println("fail");
			return -1;
		}else {
			return result;
		}
	}
	
	@PutMapping("/users/{uuid}")
	public int userUpdate(@PathVariable("uuid") int uuid, UserDto dto) {
		return userService.userUpdate(dto);
	}
	
	@DeleteMapping("/users/{uuid}")
	public int userDelete(@PathVariable("uuid") int uuid) {
		return userService.userDelete(uuid);
	}
}
