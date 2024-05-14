package com.ssafy.enjoyTrip.favorite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoyTrip.favorite.dao.FavoriteDao;
import com.ssafy.enjoyTrip.favorite.dto.FavoriteDto;
import com.ssafy.enjoyTrip.favorite.service.FavoriteService;

@SpringBootTest
public class FavoriteTest {
	
	@Autowired
	FavoriteDao favoriteDao;
	
	@Autowired
	FavoriteService favoriteService;
	
	@Test
	@Order(1)
	@DisplayName("Dao DI Test")
	public void testDao() {
		assertNotNull(favoriteDao);
	}
	
	@Test
	@Order(2)
	@DisplayName("Service DI Test")
	public void testService() {
		assertNotNull(favoriteService);
	}
	
	@Test
	@Order(3)
	@DisplayName("favorite List Dao Test")
	void testListDao() {
		int userId = 4;
		assertNotNull(favoriteDao.favoriteList(userId));
	}
	
	@Test
	@Order(4)
	@DisplayName("favorite add Dao Test")
	@Transactional
	void testAddDao() {
		FavoriteDto favoriteDto = new FavoriteDto();
		favoriteDto.setUserId(4);
		favoriteDto.setContentId(125413);
		assertEquals(1,favoriteDao.favoriteAdd(favoriteDto));
	}
	
	@Test
	@Order(5)
	@Transactional
	@DisplayName("favorite delete Dao Test")
	void testDeleteDao() {
		int favoriteId = 1;
		
		assertEquals(1, favoriteDao.favoriteDelete(favoriteId));
	}
	
	@Test
	@Order(3)
	@DisplayName("favorite List Service Test")
	void testListService() {
		int userId = 4;
		assertNotNull(favoriteService.favoriteList(userId));
	}
	
	@Test
	@Order(4)
	@DisplayName("favorite add Service Test")
	@Transactional
	void testAddService() {
		FavoriteDto favoriteDto = new FavoriteDto();
		favoriteDto.setUserId(4);
		favoriteDto.setContentId(125413);
		assertEquals(1,favoriteService.favoriteAdd(favoriteDto));
	}
	
	@Test
	@Order(5)
	@Transactional
	@DisplayName("favorite delete Service Test")
	void testDeleteService() {
		int favoriteId = 1;
		
		assertEquals(1, favoriteService.favoriteDelete(favoriteId));
	}

}
