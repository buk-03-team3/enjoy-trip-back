package com.ssafy.enjoyTrip.auth.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoyTrip.auth.dto.LoginDto;

@Mapper
public interface LoginDao {
	LoginDto login(String userEmail);
}
