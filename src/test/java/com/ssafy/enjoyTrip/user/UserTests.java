package com.ssafy.enjoyTrip.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoyTrip.user.dao.UserDao;
import com.ssafy.enjoyTrip.user.dto.UserDto;
import com.ssafy.enjoyTrip.user.service.UserService;

@SpringBootTest
public class UserTests {
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	
	@Test
	@Order(1)
	@DisplayName("Dao DI Test")
	void testDaoDI() {
		assertNotNull(userDao);
	}
	
	@Test
	@Order(2)
	@DisplayName("Service DI Test")
	void testServiceDI() {
		assertNotNull(userService);
	}
	
	@Test
	@Order(3)
	@DisplayName("register Dao Test")
	@Transactional
	void testRegister() {
		UserDto userDto = new UserDto();
		userDto.setUserEmail("ssafy1@ssafy.com");
		userDto.setUserName("김싸피");
		userDto.setUserPassword("ssafy");
		assertEquals(1,userDao.userRegister(userDto));
	}
	
	@Test
	@Order(4)
	@DisplayName("detail Dao Test")
	@Transactional
	void testUserDetail() {
		assertNotNull(userDao.userDetail(4));
		System.out.println(userDao.userDetail(4).getUserName());
	}
	
	@Test
	@Order(5)
	@DisplayName("delete Dao Test")
	@Transactional
	void testUserDelete() {
		assertEquals(1,userDao.userDelete(1));
	}
	
	@Test
	@Order(6)
	@DisplayName("update Dao Test")
	@Transactional
	void testUserUpdate() {
		UserDto userDto = new UserDto();
		userDto.setUuid(1);
		userDto.setUserEmail("ssafy@ssafy.com");
		userDto.setUserName("김싸피");
		userDto.setUserPassword("ssafy1231");
		assertEquals(1,userDao.userUpdate(userDto));
	}
	
	@Test
	@Order(7)
	@DisplayName("register Service Test")
	@Transactional
	void testRegisterService() {
		UserDto userDto = new UserDto();
		userDto.setUserEmail("ssafy1@ssafy.com");
		userDto.setUserName("김싸피");
		userDto.setUserPassword("ssafy");
		assertEquals(1,userService.userRegister(userDto));
	}
	
	@Test
	@Order(8)
	@DisplayName("detail Service Test")
	@Transactional
	void testUserDetailService() {
		assertNotNull(userService.userDetail(1));
	}
	
	@Test
	@Order(9)
	@DisplayName("delete Service Test")
	@Transactional
	void testUserDeleteService() {
		assertEquals(1,userService.userDelete(1));
	}
	
	@Test
	@Order(10)
	@DisplayName("update Service Test")
	@Transactional
	void testUserUpdateService() {
		UserDto userDto = new UserDto();
		userDto.setUuid(1);
		userDto.setUserEmail("ssafy@ssafy.com");
		userDto.setUserName("김싸피");
		userDto.setUserPassword("ssafy1231");
		assertEquals(1,userService.userUpdate(userDto));
	}
}
