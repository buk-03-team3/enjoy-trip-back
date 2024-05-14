package com.ssafy.enjoyTrip.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.enjoyTrip.travel.dao.TravelDao;
import com.ssafy.enjoyTrip.travel.dto.TravelDto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {
	private final TravelDao travelDao;
	@Override
	public List<TravelDto> selectTravelList(int sidoCode, int gugunCode) {
		
		return travelDao.selectTravelList(sidoCode, gugunCode);
	}

	@Override
	public List<TravelDto> selectTravelListWithContent(int sidoCode, int gugunCode, int contentType) {
		// TODO Auto-generated method stub
		return travelDao.selectTravelListWithContent(sidoCode, gugunCode, contentType);
	}

	@Override
	public List<TravelDto> selectTravleListWithKeyword(String keyword) {
		// TODO Auto-generated method stub
		return travelDao.selectTravleListWithKeyword(keyword);
	}

}
