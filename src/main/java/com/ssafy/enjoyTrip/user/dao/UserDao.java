package com.ssafy.enjoyTrip.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoyTrip.user.dto.UserDto;

@Mapper
public interface UserDao {
	int userRegister(UserDto userDto);
	UserDto userDetail(int userId);
	int userUpdate(UserDto userDto);
	int userDelete(int userId);
}
