package com.ssafy.enjoyTrip.user.service;

import com.ssafy.enjoyTrip.user.dto.UserDto;

public interface UserService {
	int userRegister(UserDto userDto);
	UserDto userDetail(int userId);
	int userUpdate(UserDto userDto);
	int userDelete(int userId);
}
