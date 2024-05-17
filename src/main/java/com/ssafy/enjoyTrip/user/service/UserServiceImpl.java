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

	// 최소 8자 이상, 최대 16자 이하여야 합니다.
	// 최소 하나의 영문자 (대소문자 모두 허용) 또는 숫자가 포함되어야 합니다.
	// 최소 하나의 특수문자가 포함되어야 합니다.
	private final String passwordRegex = "^(?=.*[a-zA-Z\\d])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,16}$";

	private final Pattern pattern = Pattern.compile(passwordRegex);
	@Override
	public int userRegister(UserDto userDto) {
		String userPassword = userDto.getPassword();
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
		log.info(userDao.userDetail(4).getName());
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
