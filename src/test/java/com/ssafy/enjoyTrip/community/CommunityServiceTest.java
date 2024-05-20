package com.ssafy.enjoyTrip.community;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoyTrip.community.dto.CommunityDto;
import com.ssafy.enjoyTrip.community.service.CommunityService;

@SpringBootTest
public class CommunityServiceTest {

	@Autowired
	CommunityService communityService;
	
	@Test
	public void testDi() {
		assertNotNull(communityService);
	}

	@Test
	@Transactional
	public void testcommunityInsert() {
		CommunityDto dto = new CommunityDto();
		dto.setContent("testDto22");
		dto.setTitle("TEST22");
		dto.setUserId(1);
		System.out.println(communityService.communityInsert(dto));
		assertEquals(1, communityService.communityInsert(dto));
	}

	@Test
	@Transactional
	public void testBoardUpdate() {
		CommunityDto dto = new CommunityDto();
		dto.setContent("testDto");
		dto.setTitle("TESTUpdate");
		dto.setUserId(1);
		assertEquals(1, communityService.communityInsert(dto));
	}

	@Test
	@Transactional
	public void testcommunityDelete() {
		int boardId = 24;
		assertEquals(1, communityService.communityDelete(boardId));
	}

	@Test
	public void testcommunityDetail() {
		int boardId = 24;
		int userId= 5;
		CommunityDto dto = communityService.communityDetail(boardId, userId);
		System.out.println(dto);
		assertNotNull(dto);
	}

	@Test
	public void testcommunityListTop() {
		List<CommunityDto> list = communityService.communityListTop(8);
		System.out.println(list);
		assertEquals(list.size(), 8);
	}
	
	@Test
	public void testBoardList() {
		int limit = 8;
		int offset= 5;
		List<CommunityDto> list = communityService.communityList(limit, offset);
		System.out.println(list);
		assertEquals(list.size(), 5);		
	}
	
	@Test
	public void testBoardListTotalCnt() {
		assertThat(communityService.communityListTotalCnt()).isGreaterThan(1);
	}
	
	@Test
	public void testBoardListSearchWordTotalCnt() {
		String searchWord = "번";
		assertEquals(6, communityService.communityListSearchWordTotalCnt(searchWord));
	}
	
	@Test
	public void testBoardListSearchWord() {
		String searchWord="번";
		int limit = 8;
		int offset =0;
		List<CommunityDto> list = communityService.communityListSearchWord(limit, offset, searchWord);
		System.out.println("testBoardListSearchWord"+list);
		assertThat(list.size()).isGreaterThan(1);
	}
}
