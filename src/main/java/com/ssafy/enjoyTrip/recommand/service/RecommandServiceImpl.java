package com.ssafy.enjoyTrip.recommand.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.enjoyTrip.recommand.dao.RecommandDao;
import com.ssafy.enjoyTrip.recommand.dto.RecommandDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommandServiceImpl implements RecommandService{
	
	private final RecommandDao recommandDao;
	
	@Override
	public List<RecommandDto> recommandWithAddr(int userId) {
		return recommandDao.recommandWithAddr(userId);
	}

	@Override
	public List<RecommandDto> recommandPopular(int userId) {
		return recommandDao.recommandPopular();
	}

	@Override
	public List<RecommandDto> recommandByType(int userId) {
		return recommandDao.recommandByType(userId);
	}
}
