package com.ssafy.enjoyTrip.recommand.service;

import java.util.List;

import com.ssafy.enjoyTrip.recommand.dto.RecommandDto;

public interface RecommandService {
	List<RecommandDto> recommandWithAddr(int userId);
	List<RecommandDto> recommandPopular(int userId);
	List<RecommandDto> recommandByType(int userId);
}
