package com.ssafy.enjoyTrip.user.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.ssafy.enjoyTrip.user.dao.UserDao;
import com.ssafy.enjoyTrip.user.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
	
	private final UserDao userDao;
	private final String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{8,16}$";
	private final Pattern pattern = Pattern.compile(passwordRegex);
	@Override
	public int userRegister(UserDto userDto) {
		String userPassword = userDto.getUserPassword();
		Matcher matcher = pattern.matcher(userPassword);
        if (matcher.matches()) {
            System.out.println("비밀번호가 규칙에 맞습니다.");
    		return userDao.userRegister(userDto);
        } else {
            System.out.println("비밀번호가 규칙에 맞지 않습니다.");
            return -1;
        }
	}

	@Override
	public UserDto userDetail(int userId) {
		log.info("userId={}",userId);
		log.info(userDao.userDetail(4).getUserName());
		return userDao.userDetail(userId);
	}

	@Override
	public int userUpdate(UserDto userDto) {
		return userDao.userUpdate(userDto);
	}

	@Override
	public int userDelete(int userId) {
		return userDao.userDelete(userId);
	}

}
