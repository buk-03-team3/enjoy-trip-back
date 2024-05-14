package com.ssafy.enjoyTrip.recommand.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoyTrip.recommand.dto.RecommandDto;

@Mapper
public interface RecommandDao {
	List<RecommandDto> recommandWithAddr(int uuid);
	List<RecommandDto> recommandPopular(int uuid);
	List<RecommandDto> recommandByType(int uuid);
}
