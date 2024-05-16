package com.ssafy.enjoyTrip.travel;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.enjoyTrip.travel.dao.TravelDao;
import com.ssafy.enjoyTrip.travel.dto.TravelDto;
import com.ssafy.enjoyTrip.travel.service.TravelService;

@SpringBootTest
public class TestTravel {
	@Autowired
	TravelDao travelDao;
	
	@Autowired
	TravelService travelService;
	@Test
	void testDi() {
		assertNotNull(travelDao);
	}
	
	@Test
	void testServiceDi() {
		assertNotNull(travelService);
	}
	
	@Test
	@DisplayName("travelDao 시도코드,구군코드로 관광지 조회")
	void testTravelDaoSelectList() {
		int sidoCode= 1;
		int gugunCode =1;
		List<TravelDto> list=travelDao.selectTravelList(sidoCode, gugunCode);
		assertNotEquals(list.size(),0);
	}
	
	@Test
	@DisplayName("travelDao 시도코드,구군코드, 컨텐츠타입으로 관광지 조회")
	void testTravelDaoSelectListWithContent() {
		int sidoCode= 1;
		int gugunCode =1;
		String contentType= "12/38";
		String[] split = contentType.split("/");
		List<TravelDto> list=travelDao.selectTravelListWithContent(sidoCode, gugunCode, Arrays.stream(split).toList());
		System.out.println(list.size());
		assertNotEquals(list.size(),0);
	}
	
	@Test
	@DisplayName("travelDao 검색어로 관광지 조회")
	void testTravelDaoselectTravleListWithKeyword() {
		String keyword = "포항";
		List<TravelDto> list=travelDao.selectTravleListWithKeyword(keyword);
		assertNotEquals(list.size(),0);
	}
	
}
