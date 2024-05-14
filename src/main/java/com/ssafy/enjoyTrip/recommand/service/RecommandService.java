package com.ssafy.enjoyTrip.recommand.service;

import java.util.List;

import com.ssafy.enjoyTrip.recommand.dto.RecommandDto;

public interface RecommandService {
	List<RecommandDto> recommandWithAddr(int uuid);
	List<RecommandDto> recommandPopular(int uuid);
	List<RecommandDto> recommandByType(int uuid);
}
