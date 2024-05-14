package com.ssafy.enjoyTrip.auth.controller;

import java.util.HashMap;
import java.util.Map;

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
public class LoginController {
	
	private final LoginService service;
	
	@PostMapping("/login")
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
	public ResponseEntity<String> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
}
