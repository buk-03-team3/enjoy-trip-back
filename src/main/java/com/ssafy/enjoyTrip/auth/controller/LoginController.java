package com.ssafy.enjoyTrip.auth.controller;

import java.util.HashMap;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoyTrip.auth.dto.LoginDto;
import com.ssafy.enjoyTrip.auth.dto.LoginResultDto;
import com.ssafy.enjoyTrip.auth.service.LoginService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "02. 인증 관련 컨트롤러 페이지", description = "인증, 회원 관련 api")
public class LoginController {
	
	private final LoginService service;
	
	@PostMapping("/login")
	@Operation(summary = "로그인", description = "User 로그인 기능입니다.")
	public ResponseEntity<LoginResultDto> login(LoginDto dto, HttpSession session){
		System.out.println(dto);
		LoginResultDto lrDto = service.login(dto);
		if (lrDto.getLoginDto() != null) {
			session.setAttribute("loginDto", lrDto.getLoginDto());
			
			return new ResponseEntity<LoginResultDto>(lrDto, HttpStatus.OK);
		}
		
		return new ResponseEntity<LoginResultDto>(lrDto, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/logout")
	@Operation(summary = "로그아웃", description = "User 로그아웃 기능입니다.")
	public ResponseEntity<String> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
}
