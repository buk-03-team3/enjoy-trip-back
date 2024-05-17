package com.ssafy.enjoyTrip.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.enjoyTrip.user.dto.UserDto;
import com.ssafy.enjoyTrip.user.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
@Tag(name = "01. 유저 관련 컨트롤러 페이지", description = "인증, 회원 관련 api")
public class UserController {
	private final UserService userService;
	
	@GetMapping("/{userId}")
	@Operation(summary = "User 정보 조회", description = "User의 정보를 조회하는 기능입니다.")
	public UserDto userDetail(@PathVariable("userId") int userId) {
		UserDto dto = userService.userDetail(userId);
		return dto;
	}
	
//	@GetMapping("/users/find/{email}")
//	public String findPassword(@PathVariable("email") String email) {
//		// TODO: implement find password
//		return "password";
//	}
	
	@PostMapping
	@Operation(summary = "User 회원가입", description = "User의 회원가입 기능입니다.")
	public ResponseEntity<Map<String, String>> userRegister(@RequestBody UserDto user) {
		int result = userService.userRegister(user);
		if(result == 1) {
			return new ResponseEntity<>(Map.of("result", "success"), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(Map.of("result", "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{userId}")
	@Operation(summary = "User 정보 수정", description = "User의 정보를 수정하는 기능입니다.")
	public int userUpdate(@PathVariable("userId") int userId, UserDto dto) {
		return userService.userUpdate(dto);
	}
	
	@DeleteMapping("/{userId}")
	@Operation(summary = "User 정보 삭제", description = "User의 정보를 삭제하는 기능입니다.")
	public int userDelete(@PathVariable("userId") int userId) {
		return userService.userDelete(userId);
	}
}
