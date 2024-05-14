package com.ssafy.enjoyTrip.sidogugun;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.enjoyTrip.util.sidogugun.dao.SidoGugunDao;
import com.ssafy.enjoyTrip.util.sidogugun.dto.GugunCodeDto;
import com.ssafy.enjoyTrip.util.sidogugun.dto.SidoCodeDto;
import com.ssafy.enjoyTrip.util.sidogugun.service.SidoGugunService;

@SpringBootTest
public class SidogugunTest {
	
	@Autowired
	SidoGugunDao sidoGugunDao;
	@Autowired
	SidoGugunService sidoGugunService;
	@Test
	public void sidoCodeDiTest() {
		assertNotNull(sidoGugunDao);
	}
	
	@Test
	@DisplayName("sidoCodeList를 가져오는 dao 테스트")
	public void sidoCodeListTest() {
		List<SidoCodeDto> list=(List<SidoCodeDto>) sidoGugunDao.sidoCodeList();
		System.out.println(list);
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void gugunCodeTest() {
		String sidoCode = "1";
		List<GugunCodeDto> list = sidoGugunDao.gugunCodeList(sidoCode);
		System.out.println(list);
		assertNotEquals(list.size(),0);
	}
	
	@Test
	public void sidoCodeServiceTest() {
		assertNotNull(sidoGugunService);
	}
	
	@Test
	public void sidoCodeServiceSidoCodeListTest() {
		List<SidoCodeDto> list=(List<SidoCodeDto>) sidoGugunService.sidoCodeList();
		assertNotEquals(list.size(),0);
	}
	
	@Test
	public void gugunCodeServiceGugunCodeListTest() {
		String sidoCode = "1";
		List<GugunCodeDto> list=(List<GugunCodeDto>) sidoGugunService.gugunCodeList(sidoCode);
		assertNotEquals(list.size(),0);
	}
}
