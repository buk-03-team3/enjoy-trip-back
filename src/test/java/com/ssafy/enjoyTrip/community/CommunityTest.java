package com.ssafy.enjoyTrip.community;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoyTrip.community.dao.CommunityDao;
import com.ssafy.enjoyTrip.community.dto.CommunityDto;

@SpringBootTest
public class CommunityTest {

	@Autowired
	CommunityDao communityDao;

	@Test
	public void testDi() {
		assertNotNull(communityDao);
	}

	@Test
	@Transactional
	public void testCommunityInsert() {
		CommunityDto dto = new CommunityDto();
		dto.setContent("testDto");
		dto.setTitle("TEST");
		dto.setUserId(1);
		assertEquals(1, communityDao.communityInsert(dto));
	}

	@Test
	@Transactional
	public void testCommunityUpdate() {
		CommunityDto dto = new CommunityDto();
		dto.setContent("testDto");
		dto.setTitle("TESTUpdate");
		dto.setUserId(1);
		assertEquals(1, communityDao.communityInsert(dto));
	}

	@Test
	@Transactional
	public void testCommunityDelete() {
		int communityId = 24;
		assertEquals(1, communityDao.communityDelete(communityId));
	}

	@Test
	public void testCommunityDetail() {
		int communityId = 24;
		CommunityDto dto = communityDao.communityDetail(communityId);
		System.out.println(dto);
		assertNotNull(dto);
	}

	@Test
	public void testCommunityListTop() {
		List<CommunityDto> list = communityDao.communityListTop(8);
		System.out.println(list.size());
		assertEquals(list.size(), 5);
	}
	
	@Test
	public void testCommunityList() {
		int limit = 8;
		int offset= 0;
		List<CommunityDto> list = communityDao.communityList(limit, offset);
		System.out.println(list);
		assertEquals(list.size(), 5);		
	}
	
	@Test
	public void testCommunityListTotalCnt() {
		assertThat(communityDao.communityListTotalCnt()).isGreaterThan(1);
	}
	
	@Test
	public void testCommunityListSearchWordTotalCnt() {
		String searchWord = "번";
		assertEquals(6, communityDao.communityListSearchWordTotalCnt(searchWord));
	}
	
	@Test
	public void testCommunityListSearchWord() {
		String searchWord="번";
		int limit = 8;
		int offset =0;
		List<CommunityDto> list = communityDao.communityListSearchWord(limit, offset, searchWord);
		System.out.println("testcommunityListSearchWord"+list);
		assertThat(list.size()).isGreaterThan(1);
	}
}
