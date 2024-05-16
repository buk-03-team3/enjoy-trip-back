package com.ssafy.enjoyTrip.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.enjoyTrip.auth.dao.LoginDao;
import com.ssafy.enjoyTrip.auth.dto.LoginDto;
import com.ssafy.enjoyTrip.auth.dto.LoginResultDto;
import com.ssafy.enjoyTrip.auth.service.LoginService;


@SpringBootTest
public class AuthTests {
	
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	LoginService loginService;
	
	
	@Test
	@Order(1)
	@DisplayName("Dao DI Test")
	void testDaoDI() {
		assertNotNull(loginDao);
	}
	
	@Test
	@Order(2)
	@DisplayName("Dao DI Test")
	void testServiceDI() {
		assertNotNull(loginService);
	}
	
	/*@Test
	@Order(3)
	@DisplayName("Login Dao Test")
	void testLoginDao() {
		LoginDto dto = new LoginDto();
		dto.setEmail("sdf@naver.sdfsd");
		dto.setPassword("1234");
		LoginDto result = loginDao.login(email);
		System.out.println(result);
		assertEquals(dto.getPassword(), result.getPassword());
	}

	@Test
	@Order(4)
	@DisplayName("Login Service Test")
	void testLoginService() {
		LoginDto dto = new LoginDto();
		dto.setEmail("sdf@naver.sdfsd");
		dto.setPassword("1234");
		LoginResultDto result = loginService.login(dto);
		assertNotNull(result);
	}*/

}
