package com.ssafy.enjoyTrip.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "01. 유저 관련 컨트롤러 페이지", description = "인증, 회원 관련 api")
public class UserController {
	private final UserService userService;
	
	@GetMapping("/users/{uuid}")
	@Operation(summary = "User 정보 조회", description = "User의 정보를 조회하는 기능입니다.")
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
	@Operation(summary = "User 회원가입", description = "User의 회원가입 기능입니다.")
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
	@Operation(summary = "User 정보 수정", description = "User의 정보를 수정하는 기능입니다.")
	public int userUpdate(@PathVariable("uuid") int uuid, UserDto dto) {
		return userService.userUpdate(dto);
	}
	
	@DeleteMapping("/users/{uuid}")
	@Operation(summary = "User 정보 삭제", description = "User의 정보를 삭제하는 기능입니다.")
	public int userDelete(@PathVariable("uuid") int uuid) {
		return userService.userDelete(uuid);
	}
}
