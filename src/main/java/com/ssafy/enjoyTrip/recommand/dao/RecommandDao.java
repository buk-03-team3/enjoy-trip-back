package com.ssafy.enjoyTrip.recommand.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoyTrip.recommand.dto.RecommandDto;

@Mapper
public interface RecommandDao {
	List<RecommandDto> recommandWithAddr(int userId);
	List<RecommandDto> recommandPopular(int userId);
	List<RecommandDto> recommandByType(int userId);
}
